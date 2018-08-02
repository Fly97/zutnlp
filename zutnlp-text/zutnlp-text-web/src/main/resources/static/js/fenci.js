new Vue({
    el:'#app',
    data:{
        list:[]
    },
    //vue对象实例创建成功之后就会自动调用这个方法
    //如果你想写的方法在舒适化的时候就被调用的话就要要用到created这个
    created:function () {
        this.getlist();//这里定义这个方法，vue实例之后运行到这里就调用这个函数
    },
    methods:{
        getlist:function () {
            //请求服务器的api获取到品牌的数据列表
            this.$http.get('http://localhost:8888/hanlp/list').then(function (response) {
                //处理服务器异常信息提示
                if(response.body.status!=0)
                {
                    alert(response.body.message);
                    return ;
                }
                //处理正常的逻辑数据处理
                this.list=response.body.message;

            });


        }

    }
});