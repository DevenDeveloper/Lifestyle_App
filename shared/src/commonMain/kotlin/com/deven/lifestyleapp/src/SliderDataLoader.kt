package com.deven.lifestyleapp.src

import com.deven.lifestyleapp.models.SliderData
import kotlinx.serialization.json.Json

class SliderDataLoader {

    fun loadSliderData(): List<SliderData> {
        val jsonString = """
        [
            {
                "id":"1",
                "image": "img_strength",
                "title": "Strength",
                "desc": "Build muscle mass and strength for better bone health and overall daily function."
            },
            {
                "id":"2",
                "image": "img_endurance",
                "title": "Endurance",
                "desc": "Develop stamina, improve heart health and boost daily energy levels."
            },
            {
                "id":"3",
                "image": "img_balance",
                "title": "Balance",
                "desc": "Enhance stability and coordination for injury prevention and better performance in daily activities."
            },
            {
                "id":"4",
                "image": "img_flexibility",
                "title": "Flexibility",
                "desc": "Increase mobility and general comfort, reduce stiffness and prevent injuries."
            }
        ]
    """
        return Json.decodeFromString(jsonString)
    }
}
