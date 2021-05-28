<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-calendar"></i> 知识图谱管理</el-breadcrumb-item>
                <el-breadcrumb-item>三元组修改</el-breadcrumb-item>
            </el-breadcrumb>
        </div>


        <div id="kg_container" class="container">

            <el-form>
                <el-form-item>
                    <input type="text" ref="getValue" />
                    <el-button type="primary">搜索</el-button>
                </el-form-item>

            </el-form>
            <KGBuilder pid="kg_container" />
        </div>

    </div>
</template>

<script>
    import KGBuilder from './KGBuilder.vue'
    export default {
        components: {
            KGBuilder,
        },
    }

</script>
<style>
    #kg_container {
        height: 100vh;
        width: 100%;
    }
</style>
