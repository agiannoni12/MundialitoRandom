package sampo.mundialito

import scala.util.Random

class Equipo (val nombre:String, var puntos:Int, var goles:Int, var clasificado:Boolean = false ) {
  var grupo: String = ""
  var idunico = Random.nextInt(15)


}