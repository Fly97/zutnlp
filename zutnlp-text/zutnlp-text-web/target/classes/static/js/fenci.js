new Vue({
    el: '#app',
    data: {
        sites: []
    },
    created:function () {
    },
    methods: {
        sub:function(){
            var content = document.getElementById("txt");
            var postData={
                "text": content.value,
                "textid":2
            }
            $.ajax({
                async:false,
                cache:false,
                type:'POST',
                url:'/hanlp/delete',
                dataType:"json",
                contentType:'application/json',
                data:JSON.stringify(postData),
                error : function(data) {
                },
                success : function(data) {
                    alert("成功！！");
                }
            });
            this.getda();
        },
        getda: function () {
            //为了在内部函数能使用外部函数的this对象，要给它赋值了一个名叫self的变量。
            var self = this;
            $.ajax({
                url: '/hanlp/getone',
                type: 'get',
                data: {},
                dataType: 'json'
            }).then(function (res) {
                console.log(res);
                //把从json获取的数据赋值给数组
                self.sites = res;
            }).fail(function () {
                console.log('失败');
            })
        }
    }
})
