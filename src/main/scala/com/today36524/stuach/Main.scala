package com.today36524.stuach

import com.today36524.stuach.bean.{Classes, Grade, School, Student}
import com.today36524.stuach.util.ComputeUtil

object Main {
  def main(args: Array[String]): Unit = {
    val s1 = new Student
    s1 name = "小文艺"
    s1 sex = 1
    s1 yuwen = 99
    s1 shuxue = 61
    s1 yingyu = 70
    println(s1.name+"的语文成绩是"+s1.yuwen)

    val c1 = new Classes
    c1 name="初一1班"
    c1.students add(s1)
    println(c1.name+"有"+c1.students.size()+"个学生")
//
//    val g1 = new Grade
//    g1 name="初一"
//    g1.classes add(c1)
//    println(g1.name+"年级有"+g1.classes.size()+"个班级")
//
//    val sch1 = new School
//    sch1 name="市实验"
//    sch1.grades add(g1)
//    println(sch1.name+"学校有"+sch1.grades.size()+"个年级")


    println(ComputeUtil.showTop5Student(null,null,c1))
  }
}
