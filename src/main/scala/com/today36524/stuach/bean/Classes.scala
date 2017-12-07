package com.today36524.stuach.bean

import java.util.{ArrayList,List}

class Classes {
  var name = ""
  var belongedGrade : Grade = null
  /**
    * 固定的属性设为val变量
    */
  val students : List[Student] = new ArrayList[Student]()
}
