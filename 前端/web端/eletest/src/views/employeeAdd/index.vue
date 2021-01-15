<template>
  <div class="add_container">
    <div class="title">
      <h1>添加员工</h1>
    </div>
    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      label-position="left"
      :rules="rules"
      status-icon
    >
      <el-form-item label="姓名" prop="name">
        <el-col :span="11">
          <el-input v-model="form.name" />
        </el-col>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-col :span="11">
          <el-select v-model="form.gender" placeholder="性别">
            <el-option label="男" value="0" />
            <el-option label="女" value="1" />
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="入职时间" prop="date">
        <el-col :span="11">
          <el-date-picker v-model="form.date" type="date" placeholder="选择日期" style="width: 100%;" />
        </el-col>
      </el-form-item>
      <el-form-item label="职位" prop="position">
        <el-col :span="11">
          <el-input v-model="form.position" />
        </el-col>
      </el-form-item>
      <el-form-item label="月薪" prop="salary">
        <el-col :span="11">
          <el-input v-model.number="form.salary" type="number">
            <span slot="append">元</span>
          </el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="备注">
        <el-col :span="18">
          <el-input v-model="form.desc" type="textarea" />
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即添加</el-button>
        <el-button type="warning" @click="form = {...initForm}">清空输入</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        name: '',
        gender: '',
        position: '',
        salary: '',
        desc: '',
        date: ''
      },
      initForm: {
        name: '',
        gender: '',
        position: '',
        salary: '',
        desc: '',
        date: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入姓名' },
          { min: 2, max: 10, message: '长度在2-10个字符' }
        ],
        gender: [
          { required: true, message: '请选择性别' }
        ],
        date: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        salary: [
          { required: true, message: '请输入工资' }
        ],
        position: [
          { required: true, message: '请输入职位' }
        ]
      }
    }
  },
  methods: {
    onSubmit() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          console.log(this.form)
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.$router.push('/employee/management')
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .add_container {
    margin: 20px;
    height: 580px;
    background-color: #fff;
    padding: 15px;

    .title {

      h1 {
        font-size: 28px;
      }
    }
  }
</style>
