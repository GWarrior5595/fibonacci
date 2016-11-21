def fibonacciSequenceIterative(position: Int) = {
  val sequence = new Array[Int](position)

  if(position >= 1){
    sequence(0) = 1
  }

  if(position >= 2){
    sequence(1) = 1
  }

  for(i <- 2 until position){
    sequence(i) = sequence(i - 1) + sequence(i - 2)
  }

  sequence
}

def fibonacciSequenceRecursive(position: Int) : List[Int] = 
  position match {
      case 1 => List(1)
      case _ => {
        val previous = fibonacciSequenceRecursive(position - 1)
        previous :+ previous.takeRight(2).sum
      }
  }

def fibonacciSequenceIterativeImmutability(position: Int) = {
  Iterator.iterate((1, 1)){
    case (prevSeq, prevPrevSeq) => (prevPrevSeq, prevSeq + prevPrevSeq)
  }.map(_._1).take(position)
}

println(fibonacciSequenceIterative(args(0).toInt).mkString(" "))

println(fibonacciSequenceIterativeImmutability(args(0).toInt).mkString(" "))

println(fibonacciSequenceRecursive(args(0).toInt).mkString(" "))