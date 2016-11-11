package com.fps.datagen.pokemon

/**
 * Pokemon model
 *
 * @author medge
 */
case class Pokemon(
  pokedexId: Int,
  name: String,
  typeA: String /* PokeType */ ,
  typeB: String /* PokeType */ , // For Pokemon with a single type: typeB == typeA
  level: Int = 1
)

object Pokemon {

  /**
   * If only one type is provided, typeB is auto-filled as typeA
   */
  def apply(pId: Int, name: String, typeA: String, level: Int) = {
    new Pokemon(pId, name, typeA, typeA, level)
  }

  /**
   * If typeB and Level are omitted
   */
  def apply(pId: Int, name: String, typeA: String) = {
    new Pokemon(pId, name, typeA, typeA)
  }

  val Bulbasaur  = Pokemon(1, "Bulbasaur", PokeType.Grass, PokeType.Poison)
  val Ivysaur    = Pokemon(2, "Ivysaur", PokeType.Grass, PokeType.Poison)
  val Venusaur   = Pokemon(3, "Venusaur", PokeType.Grass, PokeType.Poison)
  val Charmander = Pokemon(4, "Charmander", PokeType.Fire)
  val Charmeleon = Pokemon(5, "Charmeleon", PokeType.Fire)
  val Charizard  = Pokemon(6, "Charizard", PokeType.Fire)
  val Squirtle   = Pokemon(7, "Squirtle", PokeType.Water)
  val Wartortle  = Pokemon(8, "Wartortle", PokeType.Water)
  val Blastoise  = Pokemon(9, "Blastoise", PokeType.Water)
  val Caterpie   = Pokemon(10, "Caterpie", PokeType.Bug)
  val Metapod    = Pokemon(11, "Metapod", PokeType.Bug)
  val Butterfree = Pokemon(12, "Butterfree", PokeType.Bug, PokeType.Flying)
  val Weedle     = Pokemon(13, "Weedle", PokeType.Bug, PokeType.Poison)
  val Kakuna     = Pokemon(14, "Kakuna", PokeType.Bug, PokeType.Poison)
  val Beedrill   = Pokemon(15, "Beedrill", PokeType.Bug, PokeType.Poison)
  val Pidgey     = Pokemon(16, "Pidgey", PokeType.Normal, PokeType.Flying)
  val Pidgeotto  = Pokemon(17, "Pidgeotto", PokeType.Normal, PokeType.Flying)
  val Pidgeot    = Pokemon(18, "Pidgeot", PokeType.Normal, PokeType.Flying)
  val Rattata    = Pokemon(19, "Rattata", PokeType.Normal)
  val Raticate   = Pokemon(20, "Raticate", PokeType.Normal)
  val Spearow    = Pokemon(21, "Spearow", PokeType.Normal, PokeType.Flying)
  val Fearow     = Pokemon(22, "Fearow", PokeType.Normal, PokeType.Flying)
  val Ekans      = Pokemon(23, "Ekans", PokeType.Poison)
  val Arbok      = Pokemon(24, "Arbok", PokeType.Poison)
  val Pikachu    = Pokemon(25, "Pikachu", PokeType.Electric)
  val Raichu     = Pokemon(26, "Raichu", PokeType.Electric)
  val Sandshrew  = Pokemon(27, "Sandshrew", PokeType.Ground)
  val Sandslash  = Pokemon(28, "Sandslash", PokeType.Ground)
  val NidoranF   = Pokemon(29, "NidoranF", PokeType.Poison)
  val Nidorina   = Pokemon(30, "Nidorina", PokeType.Poison)
  val Nidoqueen  = Pokemon(31, "Nidoqueen", PokeType.Poison, PokeType.Ground)
  val NidoranM   = Pokemon(32, "NidoranM", PokeType.Poison)
  val Nidorino   = Pokemon(33, "Nidorino", PokeType.Poison)
  val Nidoking   = Pokemon(34, "Nidoking", PokeType.Poison, PokeType.Ground)
  val Clefairy   = Pokemon(35, "Clefairy", PokeType.Fairy)
  val Clefable   = Pokemon(36, "Clefable", PokeType.Fairy)
  val Vulpix     = Pokemon(37, "Vulpix", PokeType.Fire)
  val Ninetails  = Pokemon(38, "Ninetails", PokeType.Fire)
  val Jigglypuff = Pokemon(39, "Jigglypuff", PokeType.Normal, PokeType.Fairy)
  val Wigglytuff = Pokemon(40, "Wigglytuff", PokeType.Normal, PokeType.Fairy)
  val Zubat      = Pokemon(41, "Zubat", PokeType.Poison, PokeType.Flying)
  val Golbat     = Pokemon(42, "Golbat", PokeType.Poison, PokeType.Flying)
  val Oddish     = Pokemon(43, "Oddish", PokeType.Grass, PokeType.Poison)
  val Gloom      = Pokemon(44, "Gloom", PokeType.Grass, PokeType.Poison)
  val Vileplume  = Pokemon(45, "Vileplume", PokeType.Grass, PokeType.Poison)
  val Paras      = Pokemon(46, "Paras", PokeType.Bug, PokeType.Grass)
  val Parasect   = Pokemon(47, "Parasect", PokeType.Bug, PokeType.Grass)
  val Venonat    = Pokemon(48, "Venonat", PokeType.Bug, PokeType.Poison)
  val Venomoth   = Pokemon(49, "Venomoth", PokeType.Bug, PokeType.Poison)
  val Diglett    = Pokemon(50, "Diglett", PokeType.Ground)
  val Dugtrio    = Pokemon(51, "Dugtrio", PokeType.Ground)
  val Meowth     = Pokemon(52, "Meowth", PokeType.Normal)
  val Persian    = Pokemon(53, "Persian", PokeType.Normal)
  val Psyduck    = Pokemon(54, "Psyduck", PokeType.Water)
  val Golduck    = Pokemon(55, "Golduck", PokeType.Water)
  val Mankey     = Pokemon(56, "Mankey", PokeType.Fighting)
  val Primeape   = Pokemon(57, "Primeape", PokeType.Fighting)
  val Growlithe  = Pokemon(58, "Growlithe", PokeType.Fire)
  val Arcanine   = Pokemon(59, "Arcanine", PokeType.Fire)
  val Poliwag    = Pokemon(60, "Poliwag", PokeType.Water)
  val Poliwhirl  = Pokemon(61, "Poliwhirl", PokeType.Water)
  val Poliwrath  = Pokemon(62, "Poliwrath", PokeType.Water, PokeType.Fighting)
  val Abra       = Pokemon(63, "Abra", PokeType.Psychic)
  val Kadabra    = Pokemon(64, "Kadabra", PokeType.Psychic)
  val Alakazam   = Pokemon(65, "Alakazam", PokeType.Psychic)
  val Machop     = Pokemon(66, "Machop", PokeType.Fighting)
  val Machoke    = Pokemon(67, "Machoke", PokeType.Fighting)
  val Machamp    = Pokemon(68, "Machamp", PokeType.Fighting)
  val Bellsprout = Pokemon(69, "Bellsprout", PokeType.Grass, PokeType.Poison)
  val Weepinbell = Pokemon(70, "Weepinbell", PokeType.Grass, PokeType.Poison)
  val Victreebel = Pokemon(71, "Victreebel", PokeType.Grass, PokeType.Poison)
  val Tentacool  = Pokemon(72, "Tentacool", PokeType.Water, PokeType.Poison)
  val Tentacruel = Pokemon(73, "Tentacruel", PokeType.Water, PokeType.Poison)
  val Geodude    = Pokemon(74, "Geodude", PokeType.Rock, PokeType.Ground)
  val Graveler   = Pokemon(75, "Graveler", PokeType.Rock, PokeType.Ground)
  val Golem      = Pokemon(76, "Golem", PokeType.Rock, PokeType.Ground)
  val Ponyta     = Pokemon(77, "Ponyta", PokeType.Fire)
  val Rapidash   = Pokemon(78, "Rapidash", PokeType.Fire)
  val Slowpoke   = Pokemon(79, "Slowpoke", PokeType.Water, PokeType.Psychic)
  val Slowbro    = Pokemon(80, "Slowbro", PokeType.Water, PokeType.Psychic)
  val Magnemite  = Pokemon(81, "Magnemite", PokeType.Electric, PokeType.Steel)
  val Magneton   = Pokemon(82, "Magneton", PokeType.Electric, PokeType.Steel)
  val Farfetchd  = Pokemon(83, "Farfetchd", PokeType.Normal, PokeType.Flying)
  val Doduo      = Pokemon(84, "Doduo", PokeType.Normal, PokeType.Flying)
  val Dodrio     = Pokemon(85, "Dodrio", PokeType.Normal, PokeType.Flying)
  val Seel       = Pokemon(86, "Seel", PokeType.Water)
  val Dewgong    = Pokemon(87, "Dewgong", PokeType.Water, PokeType.Ice)
  val Grimer     = Pokemon(88, "Grimer", PokeType.Poison)
  val Muk        = Pokemon(89, "Muk", PokeType.Poison)
  val Shelder    = Pokemon(90, "Shelder", PokeType.Water)
  val Cloyster   = Pokemon(91, "Cloyster", PokeType.Water, PokeType.Ice)
  val Gastly     = Pokemon(92, "Gastly", PokeType.Ghost, PokeType.Poison)
  val Haunter    = Pokemon(93, "Haunter", PokeType.Ghost, PokeType.Poison)
  val Gengar     = Pokemon(94, "Gengar", PokeType.Ghost, PokeType.Poison)
  val Onix       = Pokemon(95, "Onix", PokeType.Rock, PokeType.Ground)
  val Drowzee    = Pokemon(96, "Drowzee", PokeType.Psychic)
  val Hypno      = Pokemon(97, "Hypno", PokeType.Psychic)
  val Krabby     = Pokemon(98, "Krabby", PokeType.Water)
  val Kingler    = Pokemon(99, "Kingler", PokeType.Water)
  val Voltorb    = Pokemon(100, "Voltorb", PokeType.Electric)
  val Electrode  = Pokemon(101, "Electrode", PokeType.Electric)
  val Exeggcute  = Pokemon(102, "Exeggcute", PokeType.Grass, PokeType.Psychic)
  val Exeggutor  = Pokemon(103, "Exeggutor", PokeType.Grass, PokeType.Psychic)
  val Cubone     = Pokemon(104, "Cubone", PokeType.Ground)
  val Marowak    = Pokemon(105, "Marowak", PokeType.Ground)
  val Hitmonlee  = Pokemon(106, "Hitmonlee", PokeType.Fighting)
  val Hitmonchan = Pokemon(107, "Hitmonchan", PokeType.Fighting)
  val Lickitung  = Pokemon(108, "Lickitung", PokeType.Normal)
  val Koffing    = Pokemon(109, "Koffing", PokeType.Poison)
  val Weezing    = Pokemon(110, "Weezing", PokeType.Poison)
  val Rhyhorn    = Pokemon(111, "Rhyhorn", PokeType.Ground, PokeType.Rock)
  val Rhydon     = Pokemon(112, "Rhydon", PokeType.Ground, PokeType.Rock)
  val Chansey    = Pokemon(113, "Chansey", PokeType.Normal)
  val Tangela    = Pokemon(114, "Tangela", PokeType.Grass)
  val Kangaskhan = Pokemon(115, "Kangaskhan", PokeType.Normal)
  val Horsea     = Pokemon(116, "Horsea", PokeType.Water)
  val Seadra     = Pokemon(117, "Seadra", PokeType.Water)
  val Goldeen    = Pokemon(118, "Goldeen", PokeType.Water)
  val Seaking    = Pokemon(119, "Seaking", PokeType.Water)
  val Staryu     = Pokemon(120, "Staryu", PokeType.Water)
  val Starmie    = Pokemon(121, "Starmie", PokeType.Water, PokeType.Psychic)
  val MrMime     = Pokemon(122, "MrMime", PokeType.Psychic, PokeType.Fairy)
  val Scyther    = Pokemon(123, "Scyther", PokeType.Bug, PokeType.Flying)
  val Jynx       = Pokemon(124, "Jynx", PokeType.Ice, PokeType.Psychic)
  val Electabuzz = Pokemon(125, "Electabuzz", PokeType.Electric)
  val Magmar     = Pokemon(126, "Magmar", PokeType.Fire)
  val Pinsir     = Pokemon(127, "Pinsir", PokeType.Bug)
  val Tauros     = Pokemon(128, "Tauros", PokeType.Normal)
  val Magikarp   = Pokemon(129, "Magikarp", PokeType.Water)
  val Gyarados   = Pokemon(130, "Gyarados", PokeType.Water, PokeType.Flying)
  val Lapras     = Pokemon(131, "Lapras", PokeType.Water, PokeType.Ice)
  val Ditto      = Pokemon(132, "Ditto", PokeType.Normal)
  val Eevee      = Pokemon(133, "Eevee", PokeType.Normal)
  val Vaporeon   = Pokemon(134, "Vaporeon", PokeType.Water)
  val Jolteon    = Pokemon(135, "Jolteon", PokeType.Electric)
  val Flareon    = Pokemon(136, "Flareon", PokeType.Fire)
  val Porygon    = Pokemon(137, "Porygon", PokeType.Normal)
  val Omanyte    = Pokemon(138, "Omanyte", PokeType.Rock, PokeType.Water)
  val Omastar    = Pokemon(139, "Omastar", PokeType.Rock, PokeType.Water)
  val Kabuto     = Pokemon(140, "Kabuto", PokeType.Rock, PokeType.Water)
  val Kabutops   = Pokemon(141, "Kabutops", PokeType.Rock, PokeType.Water)
  val Aerodactyl = Pokemon(142, "Aerodactyl", PokeType.Rock, PokeType.Flying)
  val Snorlax    = Pokemon(143, "Snorlax", PokeType.Normal)
  val Articuno   = Pokemon(144, "Articuno", PokeType.Ice, PokeType.Flying)
  val Zapdos     = Pokemon(145, "Zapdos", PokeType.Electric, PokeType.Flying)
  val Moltres    = Pokemon(146, "Moltres", PokeType.Fire, PokeType.Flying)
  val Dratini    = Pokemon(147, "Dratini", PokeType.Dragon)
  val Dragonair  = Pokemon(148, "Dragonair", PokeType.Dragon)
  val Dragonite  = Pokemon(149, "Dragonite", PokeType.Dragon, PokeType.Flying)
  val Mewtwo     = Pokemon(150, "Mewtwo", PokeType.Psychic)
  val Mew        = Pokemon(151, "Mew", PokeType.Psychic)

}

/**
 * Object containing all possible Pokemon Types
 */
object PokeType {
  val Fire     = "Fire"
  val Grass    = "Grass"
  val Poison   = "Poison"
  val Flying   = "Flying"
  val Water    = "Water"
  val Ice      = "Ice"
  val Bug      = "Bug"
  val Normal   = "Normal"
  val Electric = "Electric"
  val Steel    = "Steel"
  val Ground   = "Ground"
  val Rock     = "Rock"
  val Fairy    = "Fairy"
  val Ghost    = "Ghost"
  val Psychic  = "Psychic"
  val Fighting = "Fighting"
  val Dragon   = "Dragon"
}
