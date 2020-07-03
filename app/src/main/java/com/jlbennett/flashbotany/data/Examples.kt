package com.jlbennett.flashbotany.data

class Examples {

    companion object {
        val families = listOf<Family>(
            Family(
                "Asteraceae",
                "Info for asters",
                listOf(//Example image URLs
                    "https://static.inaturalist.org/photos/65765123/original.jpeg?1586105726",//daisy
                    "https://static.inaturalist.org/photos/71124906/original.jpeg?1588593480",//ragwort
                    "https://static.inaturalist.org/photos/76953897/original.jpeg?1591319115",//compass
                    "https://static.inaturalist.org/photos/65757798/original.jpeg?1586102360",//coltsfoot
                    "https://static.inaturalist.org/photos/39779860/original.jpeg?1558692337"//endive
                ),
                listOf<Species>(
                    Species(
                        "Lapsana communis", "Nipplewort",
                        listOf(
                            "https://static.inaturalist.org/photos/43624500/original.jpeg",
                            "https://static.inaturalist.org/photos/53933759/original.jpg",
                            "https://static.inaturalist.org/photos/54778973/original.jpg"
                        )
                    ),
                    Species(
                        "Leucanthemum vulgare", "Oxeye Daisy",
                        listOf(
                            "https://static.inaturalist.org/photos/57462377/original.jpg",
                            "https://static.inaturalist.org/photos/57462372/original.jpg"
                        )
                    ),
                    Species(
                        "Pulicaria dysenterica", "Common Fleabane",
                        listOf(
                            "https://static.inaturalist.org/photos/51103957/original.jpg"
                        )
                    )
                )
            ),
            Family(
                "Boraginaceae",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Fringilla phasellus faucibus scelerisque eleifend donec. Tortor aliquam nulla facilisi cras fermentum odio eu feugiat. Et magnis dis parturient montes nascetur ridiculus. Gravida cum sociis natoque penatibus et magnis. Tortor posuere ac ut consequat. Sagittis id consectetur purus ut faucibus. Commodo ullamcorper a lacus vestibulum sed arcu. Cum sociis natoque penatibus et magnis dis parturient montes. Lacus laoreet non curabitur gravida arcu. Nulla facilisi etiam dignissim diam quis enim lobortis. Dignissim cras tincidunt lobortis feugiat vivamus. Enim ut sem viverra aliquet. Tortor condimentum lacinia quis vel eros. Sed felis eget velit aliquet sagittis id consectetur purus.",
                listOf(
                    "https://static.inaturalist.org/photos/44619331/original.jpg?1562857776",//forget me not.
                    "https://static.inaturalist.org/photos/79873797/original.jpg?1592677671",//indian paint
                    "https://static.inaturalist.org/photos/79588520/original.jpeg?1592538325",//phacelia
                    "https://static.inaturalist.org/photos/79782716/original.jpeg?1592643932"//alkanet
                ),
                listOf<Species>(
                    Species(
                        "Borago officinalis", "Borage",
                        listOf(
                            "https://static.inaturalist.org/photos/65667421/original.jpeg",
                            "https://static.inaturalist.org/photos/58317114/original.jpeg"
                        )
                    ),
                    Species(
                        "Cynoglossum officinale", "Houndstongue",
                        listOf(
                            "https://static.inaturalist.org/photos/19998688/original.jpeg",
                            "https://static.inaturalist.org/photos/41601100/original.jpeg"
                        )
                    ),
                    Species(
                        "Pulmonaria officinalis", "Lungwort",
                        listOf(
                            "https://static.inaturalist.org/photos/62423244/original.jpeg",
                            "https://static.inaturalist.org/photos/65735706/original.jpg"
                        )
                    )
                )
            ),
            //TODO good examples for all actual species..
            Family(
                "Lamiaceae",
                "Info on lamiaceous plants",
                listOf(
                    "https://img.crocdn.co.uk/images/products2/pl/10/00/00/07/pl1000000744.jpg",//self heal
                    "https://static.inaturalist.org/photos/66819729/original.jpeg?1586795474",//bugle
                    "https://static.inaturalist.org/photos/77236009/original.jpeg?1591462361",//woundwort
                    "https://static.inaturalist.org/photos/77860257/original.jpg?1591731111"//skullcap
                ),
                listOf<Species>(
                    Species(
                        "Betonica officinalis", "Betony",
                        listOf(
                            "https://wildflowerfinder.org.uk/Flowers/B/Betony/Betony_2016_07_06_RlyAtNewbiggin_318p7.jpg",
                            "https://upload.wikimedia.org/wikipedia/commons/8/86/Betonica_officinalis_%287775493816%29.jpg"
                        )
                    ),
                    Species(
                        "Glechoma hederacea", "Ground Ivy",
                        listOf(
                            "https://static.inaturalist.org/photos/38564208/original.jpg",
                            "https://static.inaturalist.org/photos/59670158/original.jpeg"
                        )
                    )
                )
            ),
            Family(
                "Rosaceae",
                "Petals: 5\nSepals: 5\nStamens: many\nStyles: many\nInfo: sepals alternate with petals.",
                listOf(
                    "https://static.inaturalist.org/photos/70328000/original.jpeg?1588245875",//Wood Avens
                    "https://static.inaturalist.org/photos/67281942/original.jpeg?1587107754",//Hawthorn
                    "https://static.inaturalist.org/photos/70818504/original.jpeg?1588465954",//Malus
                    "https://static.inaturalist.org/photos/41131329/original.jpeg?1559812391"//Rugosa Rose or w.e
                ),
                listOf<Species>(
                    Species(
                        "Argentina anserina", "Silverweed",
                        listOf(
                            "https://newfs.s3.amazonaws.com/taxon-images-1000s1000/Rosaceae/argentina-anserina-fl-ahaines-a.jpg",
                            "https://lh3.googleusercontent.com/proxy/94xUgBrE5cA5FEv7_B26WIDj3Gfp0oQNvnT7ZjP2uns5SR9CKFI9vfhXqS8-sfKzJQ8Eh1sFscaeMoIRPYsYXFcXVHKO9kyQoUfHQorXPR7ewV9m"
                        )
                    ),
                    Species(
                        "Potentilla reptans", "Creeping Cinquefoil",
                        listOf(
                            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Potentilla_reptans_beauvais-carriere-bracheux_60_20062008_1.jpg/1920px-Potentilla_reptans_beauvais-carriere-bracheux_60_20062008_1.jpg",
                            "https://warehouse1.indicia.org.uk/upload/Cinquefoil,%20Creeping%20(Potentilla%20reptans)%20Leicester%20Road%20before%20Quarry%20Sapcote%20SP%204950%209335%20(taken%203.6.2007),..JPG",
                            "https://www.ukwildflowers.com/Web_photos_NOP/potentilla_reptans_creeping_cinquefoil_close.jpg"
                        )
                    ),
                    Species(
                        "Potentilla sterilis", "Barren Strawberry",
                        listOf(
                            "https://www.first-nature.com/flowers/images/potentilla-sterilis1.jpg",
                            "https://lh3.googleusercontent.com/proxy/IMZnF4lsa2iwq7izHpBJfnOy4BYxysr4QsN9OAGWOVsdLpBx9CqDoWlMw7D9RQFwo2mgfoFfpiAv1tsqn_HuqlqKt2PzCQFIL91FDq-MDIJ8_1zLhwaXNxgpJI9bs_ub_bCZozIpCA"
                        )
                    ),
                    Species(
                        "Prunus spinosa", "Blackthorn",
                        listOf(
                            "https://warehouse1.indicia.org.uk/upload/p15s8a1ngi11p91bi2saj571dulk.jpg",
                            "https://warehouse1.indicia.org.uk/upload/o_1e4dpsfoh3fk1ms01ifgg8qkgee.jpg",
                            "https://warehouse1.indicia.org.uk/upload/Blackthorn%20(Prunus%20spinosa),%20Old%20Fosse%20Sapcote%20SP%204973%209206%20(taken%209.4.2009).jpg"
                        )
                    )
                )
            ),
            Family(
                "Brassicaceae",
                "Brassica info",
                listOf(
                    "https://static.inaturalist.org/photos/35376196/original.jpg?1555867097",//Jointed charlock
                    "https://static.inaturalist.org/photos/63135310/original.jpg?1583792581",//Purple Rock Cress
                    "https://static.inaturalist.org/photos/29748312/original.jpeg?1546311918"//Cabbage
                ),
                listOf<Species>(
                    Species(
                        "Lunaria annua", "Annual Honesty",
                        listOf(
                            "https://static.inaturalist.org/photos/66842215/original.jpeg?1586807018",
                            "https://static.inaturalist.org/photos/68987725/original.jpg?1587856148"
                        )
                    ),
                    Species(
                        "Alliaria petiolata", "Garlic Mustard",
                        listOf(
                            "https://static.inaturalist.org/photos/66493624/original.jpeg?1586612038",
                            "https://static.inaturalist.org/photos/74079425/original.jpeg?1590059026"
                        )
                    )
                )
            ),
            Family(
                "Fabaceae",
                "Legume info",
                listOf(
                    "https://static.inaturalist.org/photos/79460695/original.jpg?1592486073",//Broad leaved sweet pea
                    "https://static.inaturalist.org/photos/47733394/original.jpeg?1565456441",//Bush Vetch
                    "https://static.inaturalist.org/photos/71863484/original.jpg?1588984530" //Black medick
                ),
                listOf<Species>(
                    Species(
                        "Ulex europaeus", "Gorse",
                        listOf(
                            "https://static.inaturalist.org/photos/44275088/original.jpeg?1562545918",
                            "https://static.inaturalist.org/photos/33818525/original.jpg?1554048362",
                            "https://static.inaturalist.org/photos/18120970/original.jpg?1526570566"
                        )
                    ),
                    Species(
                        "Lotus corniculatus", "Bird's-foot Trefoil",
                        listOf(
                            "https://static.inaturalist.org/photos/78245543/original.jpg?1591927943",
                            "https://static.inaturalist.org/photos/77377735/original.jpg?1591520970"
                        )
                    ),
                    Species(
                        "Medicago sativa", "Alfalfa",
                        listOf(
                            "https://static.inaturalist.org/photos/77332751/original.jpg?1591492860",
                            "https://static.inaturalist.org/photos/77332792/original.jpg?1591492880",
                            "https://static.inaturalist.org/photos/77332868/original.jpg?1591492920"
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