package com.example.trainingcourseapp.datamodel

data class CountUnit(
    /**
     * 展示文本
     */
    val display: String,
    /**
     * 次数
     */
    val asCount: Int,
    /**
     * 时长
     */
    val asDuration: Long
)
