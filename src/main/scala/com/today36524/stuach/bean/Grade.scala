package com.today36524.stuach.bean

import java.util.{ArrayList, List}

class Grade {
  var name = ""
  var belongedSchool : School = null
  /**
    * 固定的属性设为val变量
    */
  val classes : List[Classes] = new ArrayList[Classes]()
}
