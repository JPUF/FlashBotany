package com.jlbennett.flashbotany.data

class Examples {

    companion object {
        val families = listOf<Family>(
            Family(
                "Asteraceae",
                "Info for asters",
                listOf(//Example image URLs
                    "daisy.jpg",//daisy
                    "ragwort.jpg",//ragwort
                    "compass.jpg",//compass
                    "coltsfoot.jpg",//coltsfoot
                    "endive.jpg"//endive
                ),
                listOf<Species>(
                    Species(
                        "Lapsana communis", "Nipplewort",
                        listOf(
                            "nipplewort1.jpg",
                            "nipplewort2.jpg",
                            "nipplewort3.jpg"
                        )
                    ),
                    Species(
                        "Leucanthemum vulgare", "Oxeye Daisy",
                        listOf(
                            "oxeye1.jpg",
                            "oxeye2.jpg"
                        )
                    ),
                    Species(
                        "Pulicaria dysenterica", "Common Fleabane",
                        listOf(
                            "fleabane.jpg"
                        )
                    )
                )
            ),
            Family(
                "Boraginaceae",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Fringilla phasellus faucibus scelerisque eleifend donec. Tortor aliquam nulla facilisi cras fermentum odio eu feugiat. Et magnis dis parturient montes nascetur ridiculus. Gravida cum sociis natoque penatibus et magnis. Tortor posuere ac ut consequat. Sagittis id consectetur purus ut faucibus. Commodo ullamcorper a lacus vestibulum sed arcu. Cum sociis natoque penatibus et magnis dis parturient montes. Lacus laoreet non curabitur gravida arcu. Nulla facilisi etiam dignissim diam quis enim lobortis. Dignissim cras tincidunt lobortis feugiat vivamus. Enim ut sem viverra aliquet. Tortor condimentum lacinia quis vel eros. Sed felis eget velit aliquet sagittis id consectetur purus.",
                listOf(
                    "forgetmenot.jpg",//forget me not.
                    "indiantpaint.jpg",//indian paint
                    "phacelia.jpg",//phacelia
                    "alkanet.jpg"//alkanet
                ),
                listOf<Species>(
                    Species(
                        "Borago officinalis", "Borage",
                        listOf(
                            "borage1.jpg",
                            "borage2.jpg"
                        )
                    ),
                    Species(
                        "Cynoglossum officinale", "Houndstongue",
                        listOf(
                            "houndstongue1.jpg",
                            "houndstongue2.jpg"
                        )
                    ),
                    Species(
                        "Pulmonaria officinalis", "Lungwort",
                        listOf(
                            "lungwort1.jpg",
                            "lungwort2.jpg"
                        )
                    )
                )
            ),
            Family(
                "Lamiaceae",
                "Info on lamiaceous plants",
                listOf(
                    "selfheal1.jpg",//self heal
                    "bugle.jpg",//bugle
                    "woundwort.jpg",//woundwort
                    "skullcap.jpg"//skullcap
                ),
                listOf<Species>(
                    Species(
                        "Betonica officinalis", "Betony",
                        listOf(
                            "betony1.jpg",
                            "betony2.jpg"
                        )
                    ),
                    Species(
                        "Glechoma hederacea", "Ground Ivy",
                        listOf(
                            "groundivy1.jpg",
                            "groundivy2.jpg"
                        )
                    )
                )
            ),
            Family(
                "Rosaceae",
                "Petals: 5\nSepals: 5\nStamens: many\nStyles: many\nInfo: sepals alternate with petals.",
                listOf(
                    "woodavens.jpg",//Wood Avens
                    "hawthorn.jpg",//Hawthorn
                    "apple.jpg",//Malus
                    "rose.jpg"//Rugosa Rose or w.e
                ),
                listOf<Species>(
                    Species(
                        "Argentina anserina", "Silverweed",
                        listOf(
                            "silverweed1.jpg",
                            "silverweed2.jpg"
                        )
                    ),
                    Species(
                        "Potentilla reptans", "Creeping Cinquefoil",
                        listOf(
                            "cinquefoil1.jpg",
                            "cinquefoil2.jpg"
                        )
                    ),
                    Species(
                        "Potentilla sterilis", "Barren Strawberry",
                        listOf(
                            "strawberry1.jpg",
                            "strawberry2.jpg"
                        )
                    ),
                    Species(
                        "Prunus spinosa", "Blackthorn",
                        listOf(
                            "blackthorn1.jpg",
                            "blackthorn2.jpg"
                        )
                    )
                )
            ),
            Family(
                "Brassicaceae",
                "Brassica info",
                listOf(
                    "charlock.jpg",//Jointed charlock
                    "rockcress.jpg",//Purple Rock Cress
                    "cabbage.jpg"//Cabbage
                ),
                listOf<Species>(
                    Species(
                        "Lunaria annua", "Annual Honesty",
                        listOf(
                            "honesty1.jpg",
                            "honesty2.jpg"
                        )
                    ),
                    Species(
                        "Alliaria petiolata", "Garlic Mustard",
                        listOf(
                            "garlicmustard1.jpg",
                            "garlicmustard2.jpg"
                        )
                    )
                )
            ),
            Family(
                "Fabaceae",
                "Legume info",
                listOf(
                    "sweetpea.jpg",//Broad leaved sweet pea
                    "vetch.jpg",//Bush Vetch
                    "blackmedick.jpg" //Black medick
                ),
                listOf<Species>(
                    Species(
                        "Ulex europaeus", "Gorse",
                        listOf(
                            "gorse1.jpg",
                            "gorse2.jpg",
                            "gorse3.jpg"
                        )
                    ),
                    Species(
                        "Lotus corniculatus", "Bird's-foot Trefoil",
                        listOf(
                            "trefoil1.jpg",
                            "trefoil2.jpg"
                        )
                    ),
                    Species(
                        "Medicago sativa", "Alfalfa",
                        listOf(
                            "alfalfa1.jpg",
                            "alfalfa2.jpg",
                            "alfalfa3.jpg"
                        )
                    )
                )
            )
        )
    }

    fun getFamilyByName(name: String): Family {
        families.forEach { family ->
            if (family.name == name)
                return family
        }
        return families[0]
    }
}