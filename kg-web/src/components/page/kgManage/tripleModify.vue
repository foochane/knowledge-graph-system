<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-calendar"></i> 知识图谱管理</el-breadcrumb-item>
                <el-breadcrumb-item>三元组修改</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">三元组修改</div>
            <div class="plugins-tips">
                选择三元组文件，支持txt、csv格式文件
            </div>
            <el-upload
                class="upload-demo"
                drag
                action="http://jsonplaceholder.typicode.com/api/posts/"
                multiple>
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                <div class="el-upload__tip" slot="tip">支持拖拽上传</div>
            </el-upload>
            <div class="content-title">手动上传</div>
            <div class="plugins-tips">
                填写三元组手动上传的知识图谱中
            </div>


            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="头实体">
                        <el-input v-model="form.name1"></el-input>
                    </el-form-item>
                    <el-form-item label="关系">
                        <el-input v-model="form.name2"></el-input>
                    </el-form-item>
                    <el-form-item label="尾实体">
                    <el-input v-model="form.name3"></el-input>
                    </el-form-item>                   
                    

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">表单提交</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>
            </div>



        </div>



    </div>
</template>

<script>
    import VueCropper  from 'vue-cropperjs';
    export default {
        name: 'upload',
        data: function(){
            return {
                defaultSrc: require('../../../../static/img/img.jpg'),
                fileList: [],
                imgSrc: '',
                cropImg: '',
                dialogVisible: false,



            form: {
                name1: '',
                name2: '',
                name3: ''
            }
            }

            
        },
        components: {
            VueCropper
        },
        methods:{
            setImage(e){
                const file = e.target.files[0];
                if (!file.type.includes('image/')) {
                    return;
                }
                const reader = new FileReader();
                reader.onload = (event) => {
                    this.dialogVisible = true;
                    this.imgSrc = event.target.result;
                    this.$refs.cropper && this.$refs.cropper.replace(event.target.result);
                };
                reader.readAsDataURL(file);
            },
            cropImage () {
                this.cropImg = this.$refs.cropper.getCroppedCanvas().toDataURL();
            },
            cancelCrop(){
                this.dialogVisible = false;
                this.cropImg = this.defaultSrc;
            },
            imageuploaded(res) {
                console.log(res)
            },
            handleError(){
                this.$notify.error({
                    title: '上传失败',
                    message: '图片上传接口上传失败，可更改为自己的服务器接口'
                });
            }
        },
        created(){
            this.cropImg = this.defaultSrc;
        },




        onSubmit() {
            this.$message.success('提交成功！');
        }


    }
</script>

<style scoped>
    .content-title{
        font-weight: 400;
        line-height: 50px;
        margin: 10px 0;
        font-size: 22px;
        color: #1f2f3d;
    }
    .pre-img{   
        width: 100px;
        height: 100px;
        background: #f8f8f8;
        border: 1px solid #eee;
        border-radius: 5px;
    }
    .crop-demo{
        display: flex;
        align-items: flex-end;
    }
    .crop-demo-btn{
        position: relative;
        width: 100px;
        height: 40px;
        line-height: 40px;
        padding: 0 20px;
        margin-left: 30px;
        background-color: #409eff;
        color: #fff;
        font-size: 14px;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .crop-input{
        position: absolute;
        width: 100px;
        height: 40px;
        left: 0;
        top: 0;
        opacity: 0;
        cursor: pointer;
    }
</style>