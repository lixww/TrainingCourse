package com.example.trainingcourseapp.datamodel

/**
 * 单次训练
 */
data class OneTrainData(
    /**
     * 训练名称
     */
    val name: String,
    /**
     * 封面图
     */
    val coverUrl: String,
    /**
     * 总时长
     */
    val totalTimeCost: String,
    /**
     * 动作列表
     */
    val actionList: List<OneActionData>,
    /**
     * 历史次数
     */
    val historyCount: Int
)
