package org.waman.scalatest_util

import java.nio.file.{FileSystemException, FileSystems, Files}

import org.scalatest.{FreeSpec, Matchers}

trait WamanCustomSpec extends FreeSpec with Matchers with FourPhaseInforming{

  //***** Utility methods *****
  def convertImplicitly[T](t: T) = t

  //***** OS *****
  trait WindowsRequirement{
    assume(System.getProperty("os.name").toLowerCase contains "windows")
  }

  trait WindowsAclRequirement extends WindowsRequirement{
    assume(FileSystems.getDefault.supportedFileAttributeViews() contains "acl")
  }

  trait WindowsAdministratorRequirement extends WindowsRequirement{
    assumeWindowsAdministrated()
  }

  private def assumeWindowsAdministrated(): Unit = {
    val symlink = Files.createTempFile(null, null)
    Files.delete(symlink)
    val target = Files.createTempFile(null, null)
    target.toFile.deleteOnExit()
    try{
      Files.createSymbolicLink(symlink, target)
    }catch{
      case ex: FileSystemException => cancel(ex.getMessage)
    }
  }

  trait PosixFileSystemRequirement{
    assume(FileSystems.getDefault.supportedFileAttributeViews() contains "posix")
  }
}
