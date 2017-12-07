package com.today36524.stuach.util

import java.util.Comparator

import com.today36524.stuach.bean.Student

class YuwenComparator extends Comparator[Student]{
  override def compare(o1: Student, o2: Student) = o2.yuwen-o1.yuwen
}
