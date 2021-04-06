<template>
    <div class="sidebar">
        <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#324157"
                 text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
                        </template>
                        <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.index">
                            {{ subItem.title }}
                        </el-menu-item>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
    import bus from '../common/bus';

    export default {
        data() {
            return {
                collapse: false,
                items: [

                    {
                        icon: 'el-icon-setting',
                        index: 'search',
                        title: '知识搜索模块 '
                    },

                    {
                        icon: 'el-icon-tickets',
                        index: '2',
                        title: '知识图谱管理',
                        subs: [

                            {
                                index: 'tripleUpload',
                                title: '三元组上传'
                            },
                            {
                                index: 'tripleModify',
                                title: '三元组修改'
                            },
                            {
                                index: 'tripleCount',
                                title: '三元组统计'
                            },
                        ]
                    },
                    {
                        icon: 'el-icon-star-on',
                        index: '3',
                        title: '表示学习运用',
                        subs: [
                            {
                                index: 'linkPrediction',
                                title: '链接预测'
                            },

                            {
                                index: 'tripleClassification',
                                title: '三元组分类'
                            },

                            {
                                icon: 'el-icon-star-on',
                                index: 'questionAndAnswer',
                                title: '知识问答'
                            }
                        ]
                    },

                    {
                        icon: 'el-icon-rank',
                        index: '4',
                        title: '电磁态势分析',
                        subs: [

                            {
                                icon: 'el-icon-star-on',
                                index: 'entityRelationship',
                                title: '实体关系图'
                            },
                            {
                                icon: 'el-icon-star-on',
                                index: 'illegalBroadcast',
                                title: '黑广播识别'
                            },
                            {
                                icon: 'el-icon-star-on',
                                index: 'spectrumPrediction',
                                title: '频谱信息预测'
                            }

                        ]
                    }


                ]
            }
        },
        computed: {
            onRoutes() {
                return this.$route.path.replace('/', '');
            }
        },
        created() {
            // 通过 Event Bus 进行组件间通信，来折叠侧边栏
            bus.$on('collapse', msg => {
                this.collapse = msg;
            })
        }
    }
</script>

<style scoped>
    .sidebar {
        display: block;
        position: absolute;
        left: 0;
        top: 70px;
        bottom: 0;
    }

    .sidebar-el-menu:not(.el-menu--collapse) {
        width: 250px;
    }

    .sidebar > ul {
        height: 100%;
    }
</style>
