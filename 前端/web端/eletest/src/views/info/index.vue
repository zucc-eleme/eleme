<template>
  <div class="info_container">
    <div class="update_btn">
      <el-button type="primary" @click="handleEidt">{{ editable ? '编辑' : '取消' }}</el-button>
    </div>
    <el-form
      :model="formData"
      label-position="left"
      label-width="80px"
      style="width: 60%; margin: 0 auto;"
    >
      <div class="form_title">
        <h1>店铺信息</h1>
      </div>
      <el-form-item label="店铺名:">
        <el-input v-model="formData.name" type="text" :disabled="editable" />
      </el-form-item>
      <el-form-item label="店铺公告:">
        <el-input v-model="formData.notice" type="textarea" :disabled="editable" />
      </el-form-item>
      <el-form-item label="起送金额:">
        <el-input v-model="formData.startupCost" type="text" :disabled="editable">
          <template slot="suffix">元</template>
        </el-input>
      </el-form-item>
      <el-form-item label="配送费:">
        <el-input v-model="formData.distributionCode" type="text" :disabled="editable">
          <template slot="suffix">元</template>
        </el-input>
      </el-form-item>
      <div class="logo">
        <span>LOGO:</span>
        <img :src="formData.pic" alt="logo">
        <el-upload
          ref="upload"
          :action="`http://118.31.2.223:8080/api/public/v1/store/logo_upload?id=${id}`"
          list-type="picture-card"
          :auto-upload="false"
          :limit="1"
          :on-change="handleChange"
          class="upload"
          :class="{hide:editable}"
        >
          <i slot="default" class="el-icon-plus" />
          <div slot="file" slot-scope="{file}">
            <img
              class="el-upload-list__item-thumbnail"
              :src="file.url"
              alt="logo"
            >
            <span class="el-upload-list__item-actions">
              <span
                v-if="!disabled"
                class="el-upload-list__item-delete"
              >
                <i class="el-icon-delete" @click="handleRemove(file)" />
              </span>
            </span>
          </div>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-upload></div>
      <el-form-item v-show="!editable" class="form_btn">
        <el-button type="warning" @click="handleCancel">取消修改</el-button>
        <el-button type="primary" @click="handleConfirm">确认修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import { getBaseInfo, updateBaseInfo } from '@/api/user'

export default {
  data: () => {
    return {
      formData: {
        name: '',
        notice: '',
        distributionCode: 0,
        startupCost: 0
      },
      oldData: {},
      editable: true,
      fileList: [],
      dialogVisible: false,
      dialogImageUrl: ''
    }
  },
  computed: {
    ...mapGetters(['id', 'name'])
  },
  created() {
    (async() => {
      const res = await getBaseInfo(this.id)
      const { name, notice, distributionCode, startupCost, pic } = res.data

      const data = {
        name,
        notice,
        distributionCode,
        startupCost,
        pic
      }

      this.formData = data
      this.oldData = JSON.parse(JSON.stringify(data))
    })()
  },
  methods: {
    ...mapActions('user', ['setAvatar']),
    handleEidt() {
      this.editable = !this.editable

      if (this.editable) {
        this.formData = JSON.parse(JSON.stringify(this.oldData))
      }
    },

    handleCancel() {
      this.editable = true
      this.formData = JSON.parse(JSON.stringify(this.oldData))
    },

    async handleConfirm() {
      const res = await updateBaseInfo({ id: this.id, data: this.formData })
      this.$refs.upload.submit()
      if (res.errorCode === 0) {
        this.$message({
          message: res.message,
          type: 'success'
        })
        this.editable = true
      } else {
        this.$message({
          message: res.message,
          type: 'error'
        })
      }
    },
    handleChange(file, fileList) {
      if (file.status === 'success') {
        this.formData.pic = file.response.path
        this.setAvatar(file.response.path)
        this.$refs.upload.clearFiles()
      }
    }
  }
}
</script>

<style lang="scss">
.info_container {
  height: 550px;
  margin: 30px;
  padding: 20px;
  background-color: #fff;

  .update_btn {
    text-align: right;
  }

  .form_title {
    text-align: center;
    h1 {
      font-size: 28px;
    }
  }

  .form_btn {
    margin-top: 10px;
    text-align: right;
  }

  .el-input.is-disabled.is-disabled {
    .el-input__inner {
      background-color: #fff;
      border: none;
      color: #333;
      cursor: pointer;
    }
  }
  .el-textarea.is-disabled .el-textarea__inner {
    background-color: #fff;
    border: none;
    color: #666;
    cursor: pointer;
  }

  .logo {
    display: flex;
    align-items: center;
    span {
      margin-right: 20px;
    }
    img {
      border: 1px solid #eee;
      width: 65px;
    }
    .upload {
      display: inline-block !important;
      margin-left: 20px;
    }
  }
}

.hide .el-upload--picture-card {
  display: none;
}

.el-upload--picture-card {
  position: relative;
  width: 65px;
  height: 65px;

  .el-icon-plus {
    position: absolute;
    top: 18px;
    left: 18px;
  }
}

.el-upload-list__item {
  width: 65px !important;
  height: 65px !important;

  img {
    width: 65px;
    height: 65px;
  }
}
</style>
