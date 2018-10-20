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

// Proving that trait myPropertyChangeSupport is working by testing it on same MyBean, as in Java code

class MyBean extends java.io.Serializable with myPropertyChangeSupport {
  var myValue: Int = 0;

  def getMyValue() = {
    myValue
  }

  def setMyValue(newValue: Int) {
    val oldValue = myValue
    myValue = newValue
    firePropertyChange("myValue", oldValue, myValue);
  }
}

class myPropertyChangeListener extends PropertyChangeListener {
    def propertyChange(event: PropertyChangeEvent) {
        val property: String = event.getPropertyName()
        val oldValue: Int = event.getOldValue().asInstanceOf[Int]
        val newValue: Int = event.getNewValue().asInstanceOf[Int]
        println("Following has been changed: " + property + " from " + oldValue + " to " + newValue);
    }
}

object Main extends App {
  val bn = new MyBean
  val myPropertyChangeListener = new myPropertyChangeListener()
  bn.addPropertyChangeListener(myPropertyChangeListener)
  bn.setMyValue(5)
}
