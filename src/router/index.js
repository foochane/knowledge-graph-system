import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/search'
        },
        {
            path: '/',
            component: resolve => require(['../components/common/Home.vue'], resolve),
            meta: { title: '自述文件' },
            children:[
                 //搜索模块
                {
                    path: '/search',
                    component: resolve => require(['../components/page/Search.vue'], resolve),
                    meta: { title: '知识搜索模块' }
                },


                // 知识图谱管理 kgManage
                {
                    path: '/tripleUpload',
                    component: resolve => require(['../components/page/kgManage/tripleUpload.vue'], resolve),
                    meta: { title: '三元组上传' }
                },
                {
                    path: '/tripleModify',
                    component: resolve => require(['../components/page/kgManage/tripleModify.vue'], resolve),
                    meta: { title: '三元组修改' }
                },
                {
                    path: '/tripleCount',
                    component: resolve => require(['../components/page/kgManage/tripleCount.vue'], resolve),
                    meta: { title: '三元组统计' }
                },


                 //表示学习运用
                 {
                    path: '/linkPrediction',
                    component: resolve => require(['../components/page/EmbeddingApp/linkPrediction.vue'], resolve),
                    meta: { title: '链接预测' }
                },
                {
                    path: '/tripleClassification',
                    component: resolve => require(['../components/page/EmbeddingApp/tripleClassification.vue'], resolve),
                    meta: { title: '三元组分类' }
                },
                {
                    path: '/questionAndAnswer',
                    component: resolve => require(['../components/page/EmbeddingApp/questionAndAnswer.vue'], resolve),
                    meta: { title: '知识问答' }
                },
                

                // 电磁态势分析
                {
                    path: '/entityRelationship',
                    component: resolve => require(['../components/page/ElectromagneticApp/entityRelationship.vue'], resolve),
                    meta: { title: '实体关系图' }
                },
                {
                    path: '/illegalBroadcast',
                    component: resolve => require(['../components/page/ElectromagneticApp/illegalBroadcast.vue'], resolve),
                    meta: { title: '黑广播识别' }
                },
                {
                    path: '/spectrumPrediction',
                    component: resolve => require(['../components/page/ElectromagneticApp/spectrumPrediction.vue'], resolve),
                    meta: { title: '频谱信息预测' }
                },



            ]
        },
        {
            path: '/login',
            component: resolve => require(['../components/page/Login.vue'], resolve)
        },
        {
            path: '/404',
            component: resolve => require(['../components/page/404.vue'], resolve)
        },
        {
            path: '/403',
            component: resolve => require(['../components/page/403.vue'], resolve)
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
})
