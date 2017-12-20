var totalRecord,currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function(){
			debugger ;
			//去首页
			to_page(1);	

		});
		
		/**
		参数为页码，选择去那一页。
		**/
		function to_page(pn){
			$.ajax({
				url : '/ssm-crud/emps',
				
				data : {'pn':pn},
				type : 'GET',
				success : function(result){
					debugger ;
					//渲染table表格
					build_emps_table(result);
					//渲染页面列表
					build_page_info(result) ;
					//渲染页面导航
					build_page_nav(result)
				}
				
			})
		}
		
		/**
		渲染SSM——CRUD表格
		
		empty() ;删除匹配元素的元素的所有的子元素。
		**/
		function build_emps_table(result){
			//查询的时候先清空数据
			$("#emps_table tbody").empty();
			$.each(result.extend.page.list,function(index,emp){
				//append向某个元素的内部追加内容，把所有匹配的元素追加
				//到另一个指定的元素的元素的集合中。
				var checkBox = $("<td><input type='checkbox' class='check_item'/></td>")
				var empIdTd = $("<td></td>").append(emp.empId);
				var empNameTd =  $("<td></td>").append(emp.empName);
				var empEmailTd =$("<td></td>").append(emp.email);
				var genderTd =  $("<td></td>").append(emp.gender);
				var dempNameTd = $("<td></td>").append(emp.department.deptName);
				
				var btn1 =$("<button></button>").addClass("btn btn-primary  btn-sm  edit_btn").append($("<span></span>")
						.addClass("glyphicon glyphicon-pencil").append("修改")).attr("update_id",emp.empId) ;
				var btn2 =$("<button></button>").addClass("btn btn-danger  btn-sm  del_btn").append($("<span></span>").
						addClass("glyphicon glyphicon-trash").append("删除")).attr("del_id",emp.empId)
				var btn =$("<td></td>").append( btn1).append(btn2);
				$("<tr></tr>").append(checkBox).append(empIdTd). append(empNameTd).append(genderTd).append(empEmailTd).append(dempNameTd).append(btn).appendTo($("#emps_table tbody"));
				
			})
			
		}
		//解析显示分页信息
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前第"+result.extend.page.pageNum+"页，总共有"+result.extend.page.pages+"页，总共"+result.extend.page.total+"条记录数")
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result){
			$("#page_nav_area").empty();
			 var ul =$("<ul></ul>").addClass("pagination") ;
		     var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href","#")) ;
		     var prePage = $("<li></li>").append($("<a></a>").append("&laquo;"));
		     //如果没有上一页不能点击
		     if(result.extend.page.hasPreviousPage==false){
		    	 firstPage.addClass("disable");
		    	 prePage.addClass("disable")
		     }else{
		    	 //首页点击
			     firstPage.click(function(){
			    	 to_page(1)
			     })
			     //上一页点击
			     prePage.click(function(){
			    	 to_page(result.extend.page.pageNum-1) ;
			    	 
			     })
		     }
		    
		     var nextPage = $("<li></li>").append($("<a></a>").append("&raquo;"));
		     var endPage = $("<li></li>").append($("<a></a>").append("末页").attr("href","#")) ;
		     //如果没有下一页不能点击
		     if(result.extend.page.hasNextPage==false){
		    	 nextPage.addClass("disable");
		    	 endPage.addClass("disable")
		     }else{
		    	 //下一个点击
			     nextPage.click(function(){
			    	 to_page(result.extend.page.pageNum+1) ;
			     })
			     //末页点击
			     endPage.click(function(){
			    	 to_page(result.extend.page.pages)
			     })
		     }
		    
		     //ul中添加首页上一个提示
		     ul.append(firstPage).append(prePage)
		     $.each(result.extend.page.navigatepageNums,function(index,item){
		    	 if(item===result.extend.page.pageNum){
		    		 var liNum = $("<li></li>").append($("<a></a>").append(item)).addClass("active");
		    	 }else{
		    		 var liNum = $("<li></li>").append($("<a></a>").append(item));
		    	 }
		    	 //每个li的点击事件
		    	 liNum.click(function(){
		    		 to_page(item) ;
		    	 });
		     
		      ul.append(liNum)
		     })
		     //添加，末页下一页提示
		     ul.append(nextPage).append(endPage) ;
		     
		     var nav = $("<nav></nav)").append(ul) ;
		       nav.appendTo($("#page_nav_area")) ;
		     
			}
		
		function toAddEmployee(){
			 $('#empName_add_input').val('') ;
			 $("#email_add_input").val('') ;
			//查出部门信息;
			getAllDeptmentInfo("#empAddModal select") ;
			
			$('#empAddModal').modal({
				backdrop :'static'
			})
		}
		
		/**
		查出所有部门信息
		**/
		function getAllDeptmentInfo(ele){
			$(ele).empty();
			$.ajax({
				url : '/ssm-crud/depts',
				type : 'GET',
				success :function(result){
					$.each(result.extend.dept,function(index,item){
						$("<option></option>").append(item.deptName).attr("value",item.deptId).appendTo(ele);
						
					})
				}
			})
		}
		
		
		
		/**
		新增员工
		**/
		function addEmployee(){
		 if(! validate_add_form()){
				return false ;
			} ;
			 
			
			//新增员工数据
			var subData=$("#empAddModal form").serialize();
			
			$.ajax({
				url : '/ssm-crud/insertEmp',
				data: subData,
				type :'POST',
				success: function(result){
					console.log(result)
					if(result.code == 200){
					if(result.extend.filedErrors.empName ){
						 $("#empName_add_input").parent().removeClass("has-error has-success");
						 $('#empName_add_input').parent().addClass("has-error") ;
						 $("#empName_add_input").next('span').text("姓名只允许输入3-16位的字母或者数字")
					}else if(result.extend.filedErrors.email ){
						 $("#email_add_input").parent().removeClass("has-error has-success");
						 $("#email_add_input").parent().addClass("has-error") ;
						 $("#email_add_input").next('span').text("邮箱输入不正确")
					}
				}else{
					$('#empAddModal').modal('hide')
					to_page(1) ;
				}
					
				}
			})
		}
		
		/**
		表单提交的数据校验。
		**/
		function validate_add_form(){
			//获取表单输入的姓名
			var empName = $('#empName_add_input').val() ;
			/* if(!judgeName(empName)){
				alert("用户名称重复,请重新输入") ;
				return false ;
			} */
			//获取email
			var email =$("#email_add_input").val() ;
			//只能输入a-z的字母或者0-9的数字
			 var regexName =/(^[a-z0-9]{3,16}$)/ ;
			 
			 var regexEmail= /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/ ;
			 
			 if(!regexName.test(empName)){
				 $("#empName_add_input").parent().removeClass();
				 $('#empName_add_input').parent().addClass("has-error has-success") ;
				 $("#empName_add_input").next('span').text("姓名只允许输入3-16位的字母或者数字")
			 }else{
				 $("#empName_add_input").parent().removeClass();
				 $('#empName_add_input').parent().addClass("has-error has-success") ;
				 $("#empName_add_input").next('span').text("")
			 } ;
			 if(!regexEmail.test(email)){
				 $("#email_add_input").parent().removeClass();
				 $("#email_add_input").parent().addClass("has-error has-success") ;
				 $("#email_add_input").next('span').text("邮箱输入不正确")
			 }else{
				 $("#email_add_input").parent().removeClass();
				 $("#email_add_input").parent().addClass("has-error has-success") ;
				 $("#email_add_input").next('span').text("") ;
			 }
			 
			 if(regexName.test(empName)&&regexEmail.test(email)){
				 return true ;
			 }else{
				 return false ;
			 }
		}	
		
		/**
	         新增用户 ajax判断用户名是否重复
		**/
		
		function judgeName(name){
			$.ajax({
				url : '/ssm-crud/judge',
				data : 'empName='+name,
				type :'GET',
				success:function(result){
					if(result.code ==200){
						return false ;
					}else{
						return true ;
					}
				}
			})
		}
			
		/**
		
	   名称输入框变动的时候向后太发AJAX的请求。
		**/
		$("#empName_add_input").change(function(){
			//获取表单输入的姓名
			var empName = $('#empName_add_input').val() ;
			$.ajax({
				url : '/ssm-crud/judge',
				data : 'empName='+empName,
				type :'GET',
				success:function(result){
					console.log(result) ;
					if(result.code ==200){
						 $("#empName_add_input").parent().removeClass("has-error has-success");
						 $('#empName_add_input').parent().addClass("has-error") ;
						 $("#empName_add_input").next('span').text("用户名重复")
					}else{
						 $("#empName_add_input").parent().removeClass("has-error has-success");
						 $('#empName_add_input').parent().addClass("has-success") ;
						 $("#empName_add_input").next('span').text("")
					}
				}
			})
			
		})	
		
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		$(document).on("click",'.edit_btn',function(){
			//最好自定义的属性用 attr ,jQuery自己内部的属性用prpo.
			var itemId = $(this).attr("update_id") ;
			
			//把ID传到数据库得到点击的用户信息
			
			getEmpById(itemId) ;
			
			getAllDeptmentInfo("#empUpdateModal select") ;
			
			//3、把员工的id传递给模态框的更新按钮
			$("#emp_update_btn").attr("edit-id",$(this).attr("update_id"));
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		})
		
		/**
		
		通过ID获取员工信息
		**/
		
		function getEmpById(id){
			
			$.ajax({
				url:"/ssm-crud/emp/"+id,
				type:"GET",
				success:function(result){
					console.log(result) ;
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
				//	$("#empUpdateModal input[name=gender]").val([empData.gender]);
				
					$("#empUpdateModal select").val([empData.deptId+'']);
				}
			});
			
		}
		
		/**
		点击修改，修改员工信息。
		**/
		$("#emp_update_btn").click(function(){
			console.log($("#empUpdateModal form").serialize()) ;
			$.ajax({
				url : "/ssm-crud/update/"+$(this).attr('edit-id'),
				data : $("#empUpdateModal form").serialize(),
				type :'PUT' ,
				success :function(result){
					$('#empUpdateModal').modal('hide')
					to_page(1) ;
				}
				
			})
			
		})
		
		/**
		点击删除按钮。
		**/
		$(document).on('click','.del_btn',function(){
			//text()，返回指定元素的所属内容。
			var empName = $(this).parents("tr").find('td:eq(1)').text();
	
			if(confirm('确认删除'+empName+'吗？')){
				
				var empId = $(this).attr('del_id') ;
				
               $.ajax({
            	   url : '/ssm-crud/delEmp/'+empId,
            	   type :'DELETE',
            	   success : function(result){
            		   
            		   to_page(1) ;
            	   }
            	   
               })
			}
		
		})
		/**
		点击全选的按钮，下面的按钮和全选的按钮的属性重复。
		**/
		$("#check_all").click(function(){	
		   $(".check_item").prop("checked",$(this).prop('checked')) ;	
			})
			/**
			下面按钮全选时候上面也可以选择全部。
			**/
		$(document).on('click','.check_item',function(){
			//当选中的checkbox和总的CheckBox相同的时候，上面的全选按钮全部选中。
			
			var flag = $('.check_item:checked').length==$('.check_item').length ;
			
			$("#check_all").prop('checked',flag) ;
			
		})
		 
		/**
		
		点击删除按钮的时候，删除全选的数据。
		**/
		
		$("#emp_delete_all_btn").click(function(){
			
			if($('.check_item:checked').length===0){
				alert("请先选择数据，在进行删除") ;
				return ;
			}
			
			var empIds ='' ;
			$.each($('.check_item:checked'),function(index,item){
				
				//取得所有id的值
			var id	=$(item).parents('tr').find('td:eq(1)').text() ;
				empIds+=id+'-'
				
			})
			//去除最后一个 -
			empIds =empIds.substring(0, empIds.length-1) ;
			
			
			if(confirm('确认进行批量删除吗？')){
			//批量删除
			$.ajax({
				url :'/ssm-crud/delEmps/'+empIds,
				type :'DELETE',
				success: function(result){
					console.log(result) ;
					to_page(1) ;
				}
			})
		}
		})
	  