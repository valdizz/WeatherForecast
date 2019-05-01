package com.valdizz.weatherforecast.model

/**
 * Class with weather data for testing.
 *
 * @author Vlad Kornev
 */
class MockData {

    fun getData(): List<Weather> {
        val data = arrayListOf<Weather>()
        data.add(Weather(cities[0], 17, WeatherImage.CLOUDY, true))
        data.add(Weather(cities[3], 10, WeatherImage.RAIN, true))
        data.add(Weather(cities[0], 17, WeatherImage.CLOUDY, false))
        data.add(Weather(cities[1], 11, WeatherImage.RAIN, false))
        data.add(Weather(cities[2], 15, WeatherImage.SNOW, false))
        data.add(Weather(cities[3], 10, WeatherImage.RAIN, false))
        data.add(Weather(cities[4], 16, WeatherImage.SUN, false))
        data.add(Weather(cities[5], 5, WeatherImage.CLOUD, false))
        data.add(Weather(cities[6], 22, WeatherImage.CLOUDY, false))
        data.add(Weather(cities[7], 35, WeatherImage.SUN, false))
        data.add(Weather(cities[8], 25, WeatherImage.CLOUDY, false))
        data.add(Weather(cities[9], 15, WeatherImage.RAIN, false))
        data.add(Weather(cities[10], 1, WeatherImage.RAIN, false))
        data.add(Weather(cities[11], 15, WeatherImage.SNOW, false))
        return data
    }

    companion object {
        val cities = arrayOf(
            City("Minsk", "Minsk is the capital of Belarus", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Belarus-Minsk-Railway_Station_Square-4.jpg/1280px-Belarus-Minsk-Railway_Station_Square-4.jpg"),
            City("Havana", "Havana is the capital of Cuba", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Línea%2C_La_Habana%2C_Cuba.jpg/1280px-Línea%2C_La_Habana%2C_Cuba.jpg"),
            City("Rome", "Rome is the capital of Italy", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Rome_Skyline_%288012016319%29.jpg/1280px-Rome_Skyline_%288012016319%29.jpg"),
            City("Kyiv", "Kiev is the capital of Ukraine", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b3/View_to_Kiev.jpg/1280px-View_to_Kiev.jpg"),
            City("Madrid", "Madrid is the capital of Spain", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Gran_Vía_%28Madrid%29_1.jpg/1280px-Gran_Vía_%28Madrid%29_1.jpg"),
            City("Paris", "Paris is the capital of France", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Paris_vue_d%27ensemble_tour_Eiffel.jpg/1280px-Paris_vue_d%27ensemble_tour_Eiffel.jpg"),
            City("Warsaw", "Warsaw is the capital of Poland", "https://upload.wikimedia.org/wikipedia/commons/b/b0/Warsaw7ob.jpg"),
            City("Beijing", "Beijing is the capital of China", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Final_T31_leaving_Beijing_Railway_Station_%2820190104165513%29.jpg/1280px-Final_T31_leaving_Beijing_Railway_Station_%2820190104165513%29.jpg"),
            City("Moscow", "Moscow is the capital of Russia", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Moscow-City_%2836211143494%29.jpg/1280px-Moscow-City_%2836211143494%29.jpg"),
            City("Cairo", "Cairo is the capital of Egypt", "https://upload.wikimedia.org/wikipedia/commons/3/3b/Kairo_001.jpg"),
            City("Melbourne", "Melbourne is the capital of Australia", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Melbourne_skyline_2008.jpg/1280px-Melbourne_skyline_2008.jpg"),
            City("London", "London is the capital of UK", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/London_from_a_hot_air_balloon.jpg/1280px-London_from_a_hot_air_balloon.jpg")
        )
    }
}