<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item
          ><i class="el-icon-lx-calendar"></i>
          表示学习内部运用</el-breadcrumb-item
        >
        <el-breadcrumb-item>链接预测</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="content-title">实体链接</div>
      <div class="plugins-tips">
        请输入需要链接预测的三元组，空缺的部分用？表示，实例：（？,r,t）,（h,？,t）,（h,r,？）
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
            <el-button type="primary" @click="onSubmit">实体链接</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>

      <div class="content-title">实体链接预测结果排序：</div>
      <div class="plugins-tips">1.预测结果1</div>
      <div class="plugins-tips">2.预测结果1</div>
      <div class="plugins-tips">3.预测结果1</div>
      <div class="plugins-tips">4.预测结果1</div>
      <div class="plugins-tips">5.预测结果1</div>
      <div class="plugins-tips">5.预测结果1</div>
    </div>
  </div>
</template>

<script>
import VueCropper from "vue-cropperjs";
export default {
  name: "upload",
  data: function () {
    return {
      defaultSrc: require("../../../../static/img/img.jpg"),
      fileList: [],
      imgSrc: "",
      cropImg: "",
      dialogVisible: false,

      form: {
        name1: "",
        name2: "",
        name3: "",
      },
    };
  },
  components: {
    VueCropper,
  },
  methods: {
    setImage(e) {
      const file = e.target.files[0];
      if (!file.type.includes("image/")) {
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
    cropImage() {
      this.cropImg = this.$refs.cropper.getCroppedCanvas().toDataURL();
    },
    cancelCrop() {
      this.dialogVisible = false;
      this.cropImg = this.defaultSrc;
    },
    imageuploaded(res) {
      console.log(res);
    },
    handleError() {
      this.$notify.error({
        title: "上传失败",
        message: "图片上传接口上传失败，可更改为自己的服务器接口",
      });
    },
  },
  created() {
    this.cropImg = this.defaultSrc;
  },

  onSubmit() {
    this.$message.success("提交成功！");
  },
};
</script>

<style scoped>
.content-title {
  font-weight: 400;
  line-height: 50px;
  margin: 10px 0;
  font-size: 22px;
  color: #1f2f3d;
}
.pre-img {
  width: 100px;
  height: 100px;
  background: #f8f8f8;
  border: 1px solid #eee;
  border-radius: 5px;
}
.crop-demo {
  display: flex;
  align-items: flex-end;
}
.crop-demo-btn {
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
.crop-input {
  position: absolute;
  width: 100px;
  height: 40px;
  left: 0;
  top: 0;
  opacity: 0;
  cursor: pointer;
}
</style>