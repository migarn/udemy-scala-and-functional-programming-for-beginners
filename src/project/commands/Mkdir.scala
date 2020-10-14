package project.commands
import project.files.{DirEntry, Directory}
import project.filesystem.State

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not containt separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    } else {
      doMkdir(state, name)
    }
  }

  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, str: String): State = {

    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        println(path)
        println(path.head)
        println(path.isEmpty)
        println(currentDirectory.findEntry(path.head))
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }

    val wd = state.wd
    val allDirsInPath = wd.getAllFoldersInPath
    val newDir = Directory.empty(wd.path, name)
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)
    val newWd = newRoot.findDescendant(allDirsInPath)
    State(newRoot, newWd)
  }

}
