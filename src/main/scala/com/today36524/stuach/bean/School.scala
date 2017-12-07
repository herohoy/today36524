package com.today36524.stuach.bean

import java.util.{ArrayList,List}

class School {
  var name = ""
  /**
    * 固定的属性设为val变量
    */
  val grades : List[Grade] = new ArrayList[Grade]
}
