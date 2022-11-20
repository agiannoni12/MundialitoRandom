package sampo.mundialito

class Grupo (val nombre:String, var equipos:Array[Equipo], var clasificados: Array[Equipo]) extends Acciones {

  def getClasificados: Array[Equipo] = {
    var resultado = equipos.sortBy(e=> (e.puntos,e.goles)).reverse.slice(0,2)
    resultado.foreach(e=> e.clasificado = true)
    resultado
  }

  def agregarEquiposAgrupo(listaEquipos: Array[Equipo]): Unit = {
    listaEquipos.foreach(_.grupo = this.nombre)
    this.equipos = this.equipos ++ listaEquipos
  }
  var partidos: Array[Array[Equipo]] = Array(Array())

}
