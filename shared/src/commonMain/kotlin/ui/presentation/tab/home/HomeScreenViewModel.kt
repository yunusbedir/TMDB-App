package ui.presentation.tab.home

import domain.model.result.MediaType
import domain.model.result.TrendMediaModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ui.base.BaseScreenModel

class HomeScreenViewModel : BaseScreenModel() {

    init {
        println("MY_LOG , HomeScreenViewModel.init")
    }

    override fun onDispose() {
        println("MY_LOG , HomeScreenViewModel.onDispose()")
        super.onDispose()
    }

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState
        get() = _uiState.asStateFlow()

    fun getMovies() {
        viewModelScope.launch {
            delay(1000)
            _uiState.update {
                it.copy(
                    trendsOfDay = listOf(
                        TrendMediaModel(
                            id = "832502",
                            title = "The Monkey King",
                            posterPath = "https://image.tmdb.org/t/p/original/2D6ksPSChcRcZuvavrae9g4b8oh.jpg",
                            mediaType = MediaType.MOVIE,
                        ),
                        TrendMediaModel(
                            id = "976573",
                            title = "Elemental",
                            posterPath = "https://image.tmdb.org/t/p/original/6oH378KUfCEitzJkm07r97L0RsZ.jpg",
                            mediaType = MediaType.MOVIE,
                        ),
                        TrendMediaModel(
                            id = "565770",
                            title = "Blue Beetle",
                            posterPath = "https://image.tmdb.org/t/p/original/lZ2sOCMCcGaPppaXj0Wiv0S7A08.jpg",
                            mediaType = MediaType.MOVIE,
                        ),
                        TrendMediaModel(
                            id = "569094",
                            title = "Spider-Man: Across the Spider-Verse",
                            posterPath = "https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg",
                            mediaType = MediaType.MOVIE,
                        )
                    ),
                    popularMovies = listOf(
                        "popularMovies1",
                        "popularMovies2",
                        "popularMovies5"
                    ),
                    popularTvSeries = listOf(
                        "popularTvSeries1",
                        "popularTvSeries2",
                        "popularTvSeries5"
                    ),
                    bestOfTenMovies = listOf(
                        "bestOfTenMovies1",
                        "bestOfTenMovies2",
                        "bestOfTenMovies5"
                    ),
                    bestOfTenTvSeries = listOf(
                        "bestOfTenTvSeries1",
                        "bestOfTenTvSeries2",
                        "bestOfTenTvSeries5"
                    )
                )
            }
        }
    }
}

/**
 * {
 *   "page": 1,
 *   "results": [
 *     {
 *       "adult": false,
 *       "backdrop_path": "/2D6ksPSChcRcZuvavrae9g4b8oh.jpg",
 *       "id": 832502,
 *       "title": "The Monkey King",
 *       "original_language": "en",
 *       "original_title": "The Monkey King",
 *       "overview": "A stick-wielding monkey teams with a young girl on an epic quest for immortality, battling demons, dragons, gods — and his own ego — along the way.",
 *       "poster_path": "/i6ye8ueFhVE5pXatgyRrZ83LBD8.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         16,
 *         14,
 *         12,
 *         10751,
 *         35
 *       ],
 *       "popularity": 51.997,
 *       "release_date": "2023-08-11",
 *       "video": false,
 *       "vote_average": 7.283,
 *       "vote_count": 30
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/jZIYaISP3GBSrVOPfrp98AMa8Ng.jpg",
 *       "id": 976573,
 *       "title": "Elemental",
 *       "original_language": "en",
 *       "original_title": "Elemental",
 *       "overview": "In a city where fire, water, land and air residents live together, a fiery young woman and a go-with-the-flow guy will discover something elemental: how much they have in common.",
 *       "poster_path": "/6oH378KUfCEitzJkm07r97L0RsZ.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         16,
 *         35,
 *         10751,
 *         14,
 *         10749
 *       ],
 *       "popularity": 5064.973,
 *       "release_date": "2023-06-14",
 *       "video": false,
 *       "vote_average": 7.746,
 *       "vote_count": 1163
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/H6j5smdpRqP9a8UnhWp6zfl0SC.jpg",
 *       "id": 565770,
 *       "title": "Blue Beetle",
 *       "original_language": "en",
 *       "original_title": "Blue Beetle",
 *       "overview": "Recent college grad Jaime Reyes returns home full of aspirations for his future, only to find that home is not quite as he left it. As he searches to find his purpose in the world, fate intervenes when Jaime unexpectedly finds himself in possession of an ancient relic of alien biotechnology: the Scarab.",
 *       "poster_path": "/lZ2sOCMCcGaPppaXj0Wiv0S7A08.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         28,
 *         878
 *       ],
 *       "popularity": 918.069,
 *       "release_date": "2023-08-16",
 *       "video": false,
 *       "vote_average": 7.085,
 *       "vote_count": 123
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/4HodYYKEIsGOdinkGi2Ucz6X9i0.jpg",
 *       "id": 569094,
 *       "title": "Spider-Man: Across the Spider-Verse",
 *       "original_language": "en",
 *       "original_title": "Spider-Man: Across the Spider-Verse",
 *       "overview": "After reuniting with Gwen Stacy, Brooklyn’s full-time, friendly neighborhood Spider-Man is catapulted across the Multiverse, where he encounters the Spider Society, a team of Spider-People charged with protecting the Multiverse’s very existence. But when the heroes clash on how to handle a new threat, Miles finds himself pitted against the other Spiders and must set out on his own to save those he loves most.",
 *       "poster_path": "/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         16,
 *         28,
 *         12,
 *         878
 *       ],
 *       "popularity": 2501.039,
 *       "release_date": "2023-05-31",
 *       "video": false,
 *       "vote_average": 8.46,
 *       "vote_count": 3582
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/m1k24MwmoqAdKMPJDaBLwdB5Tps.jpg",
 *       "id": 724209,
 *       "title": "Heart of Stone",
 *       "original_language": "en",
 *       "original_title": "Heart of Stone",
 *       "overview": "An intelligence operative for a shadowy global peacekeeping agency races to stop a hacker from stealing its most valuable — and dangerous — weapon.",
 *       "poster_path": "/vB8o2p4ETnrfiWEgVxHmHWP9yRl.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         53,
 *         28
 *       ],
 *       "popularity": 2592.667,
 *       "release_date": "2023-08-09",
 *       "video": false,
 *       "vote_average": 7.004,
 *       "vote_count": 576
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/gVIhlO5AjWD1vXfHSj64mTkYJhe.jpg",
 *       "id": 156888,
 *       "name": "Mask Girl",
 *       "original_language": "ko",
 *       "original_name": "마스크걸",
 *       "overview": "An office worker who is insecure about her looks becomes a masked internet personality by night — until a chain of ill-fated events overtakes her life.",
 *       "poster_path": "/kwg6EZUS86xXEgaLrfstQrPYXno.jpg",
 *       "media_type": "tv",
 *       "genre_ids": [
 *         18
 *       ],
 *       "popularity": 68.708,
 *       "first_air_date": "2023-08-18",
 *       "vote_average": 8.1,
 *       "vote_count": 16,
 *       "origin_country": [
 *         "KR"
 *       ]
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/f7UI3dYpr7ZUHGo0iIr1Qvy1VPe.jpg",
 *       "id": 1040148,
 *       "title": "Ruby Gillman, Teenage Kraken",
 *       "original_language": "en",
 *       "original_title": "Ruby Gillman, Teenage Kraken",
 *       "overview": "Ruby Gillman, a sweet and awkward high school student, discovers she's a direct descendant of the warrior kraken queens. The kraken are sworn to protect the oceans of the world against the vain, power-hungry mermaids. Destined to inherit the throne from her commanding grandmother, Ruby must use her newfound powers to protect those she loves most.",
 *       "poster_path": "/kgrLpJcLBbyhWIkK7fx1fM4iSvf.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         16,
 *         10751,
 *         14,
 *         35
 *       ],
 *       "popularity": 748.022,
 *       "release_date": "2023-06-28",
 *       "video": false,
 *       "vote_average": 7.597,
 *       "vote_count": 558
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/rLb2cwF3Pazuxaj0sRXQ037tGI1.jpg",
 *       "id": 872585,
 *       "title": "Oppenheimer",
 *       "original_language": "en",
 *       "original_title": "Oppenheimer",
 *       "overview": "The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.",
 *       "poster_path": "/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         18,
 *         36
 *       ],
 *       "popularity": 716.79,
 *       "release_date": "2023-07-19",
 *       "video": false,
 *       "vote_average": 8.267,
 *       "vote_count": 2079
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/eDzhof8GnNXIErfkfHsAMmSd4W0.jpg",
 *       "id": 210787,
 *       "name": "Harlan Coben's Shelter",
 *       "original_language": "en",
 *       "original_name": "Harlan Coben's Shelter",
 *       "overview": "Follows the story of Mickey Bolitar after the death of his father leads him to start a new life in suburban New Jersey. When another new student disappears, Mickey finds himself tangled in a web of secrets. With the help of two new friends, Spoon and Ema, they reveal a dark underground that may hold the answers to decades of disappearances.",
 *       "poster_path": "/pbh99N5Uguoq8XWtOQmCf46eDp7.jpg",
 *       "media_type": "tv",
 *       "genre_ids": [
 *         18,
 *         9648,
 *         80
 *       ],
 *       "popularity": 49.531,
 *       "first_air_date": "2023-08-17",
 *       "vote_average": 7.9,
 *       "vote_count": 14,
 *       "origin_country": [
 *         "US"
 *       ]
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/WyGsyzSwGN4ZY9ZG2SJzGM4UPe.jpg",
 *       "id": 885331,
 *       "title": "Gadar 2",
 *       "original_language": "hi",
 *       "original_title": "गदर २",
 *       "overview": "During the Indo-Pakistani War of 1971, Tara Singh returns to Pakistan to bring his son, Charanjeet, back home.",
 *       "poster_path": "/ipoUI3FzVTczg2r8mYxNlE5SsMh.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         28,
 *         18,
 *         53
 *       ],
 *       "popularity": 167.564,
 *       "release_date": "2023-08-11",
 *       "video": false,
 *       "vote_average": 7.4,
 *       "vote_count": 23
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/8fczVZOBw1wy43z4ukpHxYTFFm1.jpg",
 *       "id": 1153222,
 *       "title": "LEGO Disney Princess: The Castle Quest",
 *       "original_language": "en",
 *       "original_title": "LEGO Disney Princess: The Castle Quest",
 *       "overview": "Tiana, Moana, Snow White, Rapunzel, and Ariel are off on an adventure as they are each unexpectedly transported to a mysterious castle. Shortly after arriving, they soon discover that Gaston has hatched an evil plan to take over all their kingdoms! The Princess characters must work together to solve challenges hidden deep within the castle walls and try to save their kingdoms from Gaston. Will bravery, quick-thinking, and teamwork prevail?",
 *       "poster_path": "/dr25PnZMpO8w93hWeOUIch3eouK.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         16
 *       ],
 *       "popularity": 81.423,
 *       "release_date": "2023-08-18",
 *       "video": false,
 *       "vote_average": 7.8,
 *       "vote_count": 4
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/rRcNmiH55Tz0ugUsDUGmj8Bsa4V.jpg",
 *       "id": 884605,
 *       "title": "No Hard Feelings",
 *       "original_language": "en",
 *       "original_title": "No Hard Feelings",
 *       "overview": "On the brink of losing her childhood home, Maddie discovers an intriguing job listing: wealthy helicopter parents looking for someone to “date” their introverted 19-year-old son, Percy, before he leaves for college. To her surprise, Maddie soon discovers the awkward Percy is no sure thing.",
 *       "poster_path": "/4K7gQjD19CDEPd7A9KZwr2D9Nco.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         35,
 *         10749
 *       ],
 *       "popularity": 1638.672,
 *       "release_date": "2023-06-15",
 *       "video": false,
 *       "vote_average": 7.09,
 *       "vote_count": 712
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/tTe0UgHNPnOvr7dMmkAIGIsJIIQ.jpg",
 *       "id": 99737,
 *       "name": "The Winter King",
 *       "original_language": "en",
 *       "original_name": "The Winter King",
 *       "overview": "In the fifth century, long before Britain was united, in a brutal land of warring factions and tribes where lives were often fleeting, Arthur Pendragon evolves from outcast to legendary warrior and leader.",
 *       "poster_path": "/fYx5q9hPAmbDrWzsYUDhxZJnigC.jpg",
 *       "media_type": "tv",
 *       "genre_ids": [
 *         18
 *       ],
 *       "popularity": 22.133,
 *       "first_air_date": "2023-08-20",
 *       "vote_average": 8.2,
 *       "vote_count": 5,
 *       "origin_country": [
 *         "GB"
 *       ]
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/nHf61UzkfFno5X1ofIhugCPus2R.jpg",
 *       "id": 346698,
 *       "title": "Barbie",
 *       "original_language": "en",
 *       "original_title": "Barbie",
 *       "overview": "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.",
 *       "poster_path": "/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         35,
 *         12,
 *         14
 *       ],
 *       "popularity": 1867.203,
 *       "release_date": "2023-07-19",
 *       "video": false,
 *       "vote_average": 7.427,
 *       "vote_count": 3200
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/sil4GzTAvmxFWqsp5FWZcG7adtS.jpg",
 *       "id": 1074262,
 *       "title": "10 Days of a Bad Man",
 *       "original_language": "tr",
 *       "original_title": "Kötü Adamın 10 Günü",
 *       "overview": "Battered, broken and bereaved, a private investigator must muscle his way through a tangle of lies to uncover the truth behind a mansion murder.",
 *       "poster_path": "/woY4fKio0ypWqj2uQj96tCiCRXV.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         80
 *       ],
 *       "popularity": 110.775,
 *       "release_date": "2023-08-18",
 *       "video": false,
 *       "vote_average": 7.1,
 *       "vote_count": 9
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/s0DoadromxXfQ8ptjxrLuPPPh6I.jpg",
 *       "id": 1128604,
 *       "title": "Snoopy Presents: One-of-a-Kind Marcie",
 *       "original_language": "en",
 *       "original_title": "Snoopy Presents: One-of-a-Kind Marcie",
 *       "overview": "Quiet, kindhearted introvert Marcie has lots of brilliant ideas to help her friends achieve goals and solve problems. But when the world takes notice and the spotlight lands on her, sharing those ideas becomes a challenge.",
 *       "poster_path": "/lFDPyo6mdooNcHvgy17gz1GEjg4.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         16,
 *         10751
 *       ],
 *       "popularity": 59.056,
 *       "release_date": "2023-08-17",
 *       "video": false,
 *       "vote_average": 7.714,
 *       "vote_count": 7
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/5YZbUmjbMa3ClvSW1Wj3D6XGolb.jpg",
 *       "id": 447365,
 *       "title": "Guardians of the Galaxy Vol. 3",
 *       "original_language": "en",
 *       "original_title": "Guardians of the Galaxy Vol. 3",
 *       "overview": "Peter Quill, still reeling from the loss of Gamora, must rally his team around him to defend the universe along with protecting one of their own. A mission that, if not completed successfully, could quite possibly lead to the end of the Guardians as we know them.",
 *       "poster_path": "/r2J02Z2OpNTctfOSN1Ydgii51I3.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         878,
 *         12,
 *         28
 *       ],
 *       "popularity": 873.717,
 *       "release_date": "2023-05-03",
 *       "video": false,
 *       "vote_average": 8.046,
 *       "vote_count": 4391
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/tX1BtIK97wsExyXrNzOAfHN8spA.jpg",
 *       "id": 137883,
 *       "name": "New Bandits",
 *       "original_language": "pt",
 *       "original_name": "Cangaço Novo",
 *       "overview": "Adrift and desperately needing money to pay for his ailing adoptive father's care, Ubaldo, a bank clerk who's unable to remember his childhood, receives an inheritance that will change his destiny for good. He goes to Cratará, in the heart of the northwest desert, where he'll become the leader of a pack of ruthless bandits, fulfilling the legacy of his biological father - a mythical cangaceiro.",
 *       "poster_path": "/cFxXB0WH25inmNGo7UYYGJKQq7i.jpg",
 *       "media_type": "tv",
 *       "genre_ids": [
 *         18,
 *         80,
 *         37
 *       ],
 *       "popularity": 69.801,
 *       "first_air_date": "2023-08-17",
 *       "vote_average": 7.8,
 *       "vote_count": 5,
 *       "origin_country": [
 *         "BR"
 *       ]
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/a6ptrTUH1c5OdWanjyYtAkOuYD0.jpg",
 *       "id": 37854,
 *       "name": "One Piece",
 *       "original_language": "ja",
 *       "original_name": "ワンピース",
 *       "overview": "Years ago, the fearsome Pirate King, Gol D. Roger was executed leaving a huge pile of treasure and the famous \"One Piece\" behind. Whoever claims the \"One Piece\" will be named the new King of the Pirates.\n\nMonkey D. Luffy, a boy who consumed a \"Devil Fruit,\" decides to follow in the footsteps of his idol, the pirate Shanks, and find the One Piece. It helps, of course, that his body has the properties of rubber and that he's surrounded by a bevy of skilled fighters and thieves to help him along the way.\n\nLuffy will do anything to get the One Piece and become King of the Pirates!",
 *       "poster_path": "/fcXdJlbSdUEeMSJFsXKsznGwwok.jpg",
 *       "media_type": "tv",
 *       "genre_ids": [
 *         10759,
 *         35,
 *         16
 *       ],
 *       "popularity": 576.94,
 *       "first_air_date": "1999-10-20",
 *       "vote_average": 8.721,
 *       "vote_count": 3925,
 *       "origin_country": [
 *         "JP"
 *       ]
 *     },
 *     {
 *       "adult": false,
 *       "backdrop_path": "/zN41DPmPhwmgJjHwezALdrdvD0h.jpg",
 *       "id": 615656,
 *       "title": "Meg 2: The Trench",
 *       "original_language": "en",
 *       "original_title": "Meg 2: The Trench",
 *       "overview": "An exploratory dive into the deepest depths of the ocean of a daring research team spirals into chaos when a malevolent mining operation threatens their mission and forces them into a high-stakes battle for survival.",
 *       "poster_path": "/4m1Au3YkjqsxF8iwQy0fPYSxE0h.jpg",
 *       "media_type": "movie",
 *       "genre_ids": [
 *         28,
 *         878,
 *         27
 *       ],
 *       "popularity": 1595.056,
 *       "release_date": "2023-08-02",
 *       "video": false,
 *       "vote_average": 6.953,
 *       "vote_count": 507
 *     }
 *   ],
 *   "total_pages": 1000,
 *   "total_results": 20000
 * }
 */
data class HomeScreenState(
    var trendsOfDay: List<TrendMediaModel> = listOf(),
    var popularMovies: List<String> = listOf(),
    var popularTvSeries: List<String> = listOf(),
    var bestOfTenMovies: List<String> = listOf(),
    var bestOfTenTvSeries: List<String> = listOf()
)