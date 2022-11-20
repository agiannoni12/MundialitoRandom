package sampo.mundialito




class Mundial extends Acciones {

  var grupos: collection.mutable.HashMap[String,Grupo] = collection.mutable.HashMap()
  var clasificadosGrupos: collection.mutable.HashMap[String,Array[Equipo]] = collection.mutable.HashMap()
  var octavos: Array[Array[String]]= Array(Array("A","B"),Array("C","D"),Array("E","F"),Array("G","H"))
  var cuartos: Option[Nothing] = None
  var crucesoctavos : collection.mutable.HashMap[String,Array[Equipo]] = collection.mutable.HashMap("crucesIzq"-> Array(), "crucesDer"->Array())
  var crucescuartos : collection.mutable.HashMap[String,Array[Equipo]] = collection.mutable.HashMap("crucesIzq"-> Array(), "crucesDer"->Array())
  var semifinales : Array[Equipo] = Array()
  var finalistas: Array[Equipo] = Array()
  var tercerPuesto: Array[Equipo] = Array()

  def agregarGrupo(grupo: Grupo) : collection.mutable.HashMap[String,Grupo] ={
   this.grupos += (grupo.nombre -> grupo)
  }

  def mostrarPartidos(): Unit ={
    this.grupos.toSeq.sortBy(_._1).foreach(
            grupo => println("------- Grupo %s---------".format(grupo._2.nombre))
                -> grupo._2.partidos.foreach(
                  partido=> println(partido.map(
                    equipo => "%s".format(equipo.nombre)).mkString("", " vs ", ""))))

  }



}
