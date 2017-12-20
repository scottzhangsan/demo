//包装函数
module.exports = function(grunt) {

    // 任务配置,所有插件的配置信息
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        //合并JS文件
        concat: {

            //奖金模块
            //奖金Controller代码合并
            ssmCrud: {
                src: [
                    '../../../ssm-crud/src/main/webapp/static/ssm/ssm.js'
                ],
                dest: '../../../ssm-crud/src/main/webapp/js/build/<%= pkg.name %>.js'
            }
            
            /*//build
            buildController: {
                src: [
                    '../../../ssm-crud/src/main/webapp/js/build/<%= pkg.name %>.js'
                ],
                dest: '../../../ssm-crud/src/main/webapp/js/build/s.js'
            },*/
        },
        //uglify插件的配置信息
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            
            //压缩成min版
            bankTicketMaintainController: {
                src: '../../../ssm-crud/src/main/webapp/js/build/<%= pkg.name %>.js',
                dest: '../../../ssm-crud/src/main/webapp/js/<%= pkg.name %>.min.js'
            }
        }
        // ,jshint: {
        //   options: {
        //     curly: true,
        //     eqeqeq: true,
        //     eqnull: true,
        //     browser: true,
        //     globals: {
        //       jQuery: true
        //     },
        //   },
        //   uses_defaults: ['src/main/webapp/js/controller/build/controller.js', 'src/main/webapp/js/service/build/service.js']
        //,with_overrides: {
        //   options: {
        //     curly: false,
        //     undef: true,
        //   },
        //   files: {
        //     src: ['dir3/**/*.js', 'dir4/**/*.js']
        //   },
        // }
        // }
    });

    // 告诉grunt我们将使用插件
    // 压缩插件
    grunt.loadNpmTasks('grunt-contrib-uglify');
    // 合并插件
    grunt.loadNpmTasks('grunt-contrib-concat');
    // 检查代码
    // grunt.loadNpmTasks('grunt-contrib-jshint');

    // 告诉grunt当我们在终端中输入grunt时需要做些什么
    // grunt.registerTask('default', ['concat','uglify','jshint']);
    grunt.registerTask('default', ['concat', 'uglify']);

};