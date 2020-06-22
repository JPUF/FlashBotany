package com.jlbennett.flashbotany.data

class Examples {

    companion object {
        val families = listOf<Family>(
            Family(
                "Asteraceae",
                "Info for asters",
                listOf(//Example image URLs
                    "https://static.inaturalist.org/photos/65765123/original.jpeg?1586105726",
                    "https://static.inaturalist.org/photos/71124906/original.jpeg?1588593480",
                    "https://static.inaturalist.org/photos/76953897/original.jpeg?1591319115",
                    "https://static.inaturalist.org/photos/65757798/original.jpeg?1586102360",
                    "https://static.inaturalist.org/photos/39779860/original.jpeg?1558692337"
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
                "Info for borages",
                listOf(
                    "https://static.inaturalist.org/photos/44619331/original.jpg?1562857776",
                    "https://static.inaturalist.org/photos/79873797/original.jpg?1592677671",
                    "https://static.inaturalist.org/photos/79588520/original.jpeg?1592538325",
                    "https://static.inaturalist.org/photos/79782716/original.jpeg?1592643932"
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
                    "https://img.crocdn.co.uk/images/products2/pl/10/00/00/07/pl1000000744.jpg",
                    "https://static.inaturalist.org/photos/66819729/original.jpeg?1586795474",
                    "https://static.inaturalist.org/photos/77236009/original.jpeg?1591462361",
                    "https://static.inaturalist.org/photos/77860257/original.jpg?1591731111"
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
                    "https://static.inaturalist.org/photos/70328000/original.jpeg?1588245875",
                    "https://static.inaturalist.org/photos/47763529/original.jpeg?1565472962",
                    "https://static.inaturalist.org/photos/70818504/original.jpeg?1588465954",
                    "https://static.inaturalist.org/photos/43664692/original.jpeg?1562026303",
                    "https://static.inaturalist.org/photos/41131329/original.jpeg?1559812391"
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
                        "Cotoneaster horizontalis", "Cotoneaster",
                        listOf(
                            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Rosaceae_-_Cotoneaster_horizontalis-002.JPG/1200px-Rosaceae_-_Cotoneaster_horizontalis-002.JPG",
                            "https://upload.wikimedia.org/wikipedia/commons/5/5c/Cotoneaster_horizontalis_10.jpg"
                        )
                    ),
                    Species("Potentilla reptans", "Creeping Cinquefoil",
                        listOf(
                            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Potentilla_reptans_beauvais-carriere-bracheux_60_20062008_1.jpg/1920px-Potentilla_reptans_beauvais-carriere-bracheux_60_20062008_1.jpg",
                            "https://warehouse1.indicia.org.uk/upload/Cinquefoil,%20Creeping%20(Potentilla%20reptans)%20Leicester%20Road%20before%20Quarry%20Sapcote%20SP%204950%209335%20(taken%203.6.2007),..JPG",
                            "https://www.ukwildflowers.com/Web_photos_NOP/potentilla_reptans_creeping_cinquefoil_close.jpg"
                        )
                    ),
                    Species("Potentilla sterilis", "Barren Strawberry",
                        listOf(
                            "https://www.first-nature.com/flowers/images/potentilla-sterilis1.jpg",
                            "https://lh3.googleusercontent.com/proxy/IMZnF4lsa2iwq7izHpBJfnOy4BYxysr4QsN9OAGWOVsdLpBx9CqDoWlMw7D9RQFwo2mgfoFfpiAv1tsqn_HuqlqKt2PzCQFIL91FDq-MDIJ8_1zLhwaXNxgpJI9bs_ub_bCZozIpCA"
                        )
                    ),
                    Species("Prunus spinosa", "Blackthorn",
                        listOf(
                            "https://warehouse1.indicia.org.uk/upload/p15s8a1ngi11p91bi2saj571dulk.jpg",
                            "https://warehouse1.indicia.org.uk/upload/o_1e4dpsfoh3fk1ms01ifgg8qkgee.jpg",
                            "https://warehouse1.indicia.org.uk/upload/Blackthorn%20(Prunus%20spinosa),%20Old%20Fosse%20Sapcote%20SP%204973%209206%20(taken%209.4.2009).jpg"
                        )
                    )
                )
            )
        )
    }

    fun getFamilyByName(name: String): Family {
        families.forEach { family ->
            if(family.name == name)
                return family
        }
        return families[0]
    }
}