package com.today36524.stuach.util

import java.util.Comparator

import com.today36524.stuach.bean.Student

class ShuxueComparator extends Comparator[Student]{
  override def compare(o1: Student, o2: Student) :Int = o2.shuxue-o1.shuxue
}
