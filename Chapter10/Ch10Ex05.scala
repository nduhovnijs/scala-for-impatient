import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

trait myPropertyChangeSupport {
  private val pcs = new PropertyChangeSupport(this) 
  
  def addPropertyChangeListener(listener: PropertyChangeListener) {
    pcs.addPropertyChangeListener(listener)
  }

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    pcs.addPropertyChangeListener(propertyName, listener)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean) {
    pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }
  
  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int) {
    pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Object, newValue: Object) {
    pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def firePropertyChange(event: PropertyChangeEvent) {
    pcs.firePropertyChange(event)
  }

  def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean) {
    pcs.firePropertyChange(propertyName, oldValue, newValue)
  }

  def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int) {
    pcs.firePropertyChange(propertyName, oldValue, newValue)
  }

  def firePropertyChange(propertyName: String, oldValue: Object, newValue: Object) {
    pcs.firePropertyChange(propertyName, oldValue, newValue)
  }

  def getPropertyChangeListeners(): Array[PropertyChangeListener] = {
    pcs.getPropertyChangeListeners()
  }

  def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] = {
    pcs.getPropertyChangeListeners(propertyName)
  }

  def hasListeners(propertyName: String): Boolean = {
    pcs.hasListeners(propertyName)
  }

  def removePropertyChangeListener(listener: PropertyChangeListener) {
    pcs.removePropertyChangeListener(listener)
  }

  def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    pcs.removePropertyChangeListener(propertyName, listener)
  }
}

class myPropertyChangeListener extends PropertyChangeListener {
    def propertyChange(event: PropertyChangeEvent) {
        println("Following has been changed: " + event.getPropertyName() + " from " + event.getOldValue() + " to " + event.getNewValue());
    }
}

// I have a bit of mixed feelings about this construction, I'd rather use just extended class.
// But this is to match formulation of task to mix in myPropertyChangeSupport with java.awt.Point more precise.
trait MyPoint extends java.awt.Point {
  this: myPropertyChangeSupport =>
    override def setLocation(x: Int, y: Int) {
      firePropertyChange("setLocation", (getX, getY), (x, y))
      super.setLocation(x, y)
    }
}

object Main extends App {
  val myPoint = new java.awt.Point(2, 3) with MyPoint with myPropertyChangeSupport
  val myPropertyChangeListener = new myPropertyChangeListener()
  myPoint.addPropertyChangeListener(myPropertyChangeListener)
  myPoint.setLocation(20, 30)
}