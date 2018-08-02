Vue.use(VueResource);   //这个一定要加上，指的是调用vue-resource.js
new Vue({
    el: '#app',   //div的id
    data: {
        Info: ""  //数据，名称自定
    },
    created: function () { //created方法，页面初始调用  
        var url = "http://localhost:8888/hanlp/getone";
        this.$http.get(url).then(function (data) {  //ajax请求封装
            var json = data.bodyText;
            var usedData= JSON.parse(json);
            //我的json数据参考下面
            this.Info = usedData["libraryBooks"];
        }, function (response) {   //返回失败方法调用，暂不处理
            console.info(response);
        })
    }
});
</script>