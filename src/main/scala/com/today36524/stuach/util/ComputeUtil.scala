package com.today36524.stuach.util

import java.text.DecimalFormat
import java.util.{ArrayList, List}

import com.today36524.stuach.bean.{Classes, Grade, School, Student}

object ComputeUtil {
  private val FORMAT : DecimalFormat = new DecimalFormat("#.##")

  def showTop5Student(s: School,g:Grade,c:Classes) {
    val l:List[Student] = new ArrayList[Student]()
    val sb:StringBuilder = new StringBuilder
    println("前五名统计中...")
    println(
      if(c!=null)
        top5Out(l,c)
      else if(g!=null) {
        sb.append("年级"+g.name+"的各班成绩如下：\r\n")
        for(i<-1 to g.classes.size())
          {
            sb.append("班级"+g.classes.get(i-1).name)
            sb.append(top5Out(l,c))
          }
        sb.toString()
      }
      else if(s!=null) {
        sb.append("学校"+s.name+"的各班成绩如下：\r\n")
        for(i<-1 to s.grades.size())
        {
          sb.append("年级"+s.grades.get(i-1).name+"的各班成绩如下：\r\n")
          for(j<-1 to g.classes.size())
          {
            sb.append("班级"+s.grades.get(i-1).classes.get(j-1).name)
            sb.append(top5Out(l,c))
          }
        }
        sb.toString()
      }
      else
        "无效学校/年级/班级！"
    )
  }

  /**
    * 实际计算前五名的函数
    * @param l 参与计算的学生总集合
    * @param c 当前班级
    * @return 结果字符串
    */
  private def top5Out(l:List[Student],c:Classes):String = {
    l.addAll(c.students)
    val res : StringBuilder = new StringBuilder
    val sz = (l.size() min 5)
    l.sort(new YuwenComparator)
    for(i <- 1 to sz)
    res.append(
        "语文第"+i+"名是"+l.get(i-1).name+
        "，成绩是"+l.get(i-1).yuwen+"，三科平均分是"+
      FORMAT.format((l.get(i-1).yuwen+l.get(i-1).shuxue+l.get(i-1).yingyu)/3.0)+"\r\n"
    )
    l.sort(new ShuxueComparator)
    for(i <- 1 to sz)
    res.append(
        "数学第"+i+"名是"+l.get(i-1).name+
      "，成绩是"+l.get(i-1).shuxue+"，三科平均分是"+
      FORMAT.format((l.get(i-1).yuwen+l.get(i-1).shuxue+l.get(i-1).yingyu)/3.0)+"\r\n"
    )
    l.sort(new YingyuComparator)
    for(i <- 1 to sz)
    res.append(
        "英语第"+i+"名是"+l.get(i-1).name+
      "，成绩是"+l.get(i-1).yingyu+"，三科平均分是"+
      FORMAT.format((l.get(i-1).yuwen+l.get(i-1).shuxue+l.get(i-1).yingyu)/3.0)+"\r\n"
    )
    l.sort(new TotalComparator)
    for(i <- 1 to sz)
    res.append(
        "总分第"+i+"名是"+l.get(i-1).name+
        "，成绩是"+(l.get(i-1).yuwen+l.get(i-1).shuxue+l.get(i-1).yingyu)+"，三科平均分是"+
        FORMAT.format((l.get(i-1).yuwen+l.get(i-1).shuxue+l.get(i-1).yingyu)/3.0)+"\r\n"
    )
    res.toString()
  }
}
