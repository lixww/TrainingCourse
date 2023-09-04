package com.example.trainingcourseapp.ui.datamodel

data class OneActionData(
    /**
     * 动作名称
     */
    val name: String,
    /**
     * 动作示意缩略图. 可空.
     */
    val demonstrateThumbnail: String,
    /**
     * 动作示意. 可空.
     */
    val demonstrateDetail: String,
    /**
     * 动作时长
     */
    val timeCost: CountUnit
)
