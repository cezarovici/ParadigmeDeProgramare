import os
import sys
from PyQt5.QtWidgets import QWidget, QApplication, QFileDialog
from PyQt5.uic import loadUi
from PyQt5 import QtCore


def debug_trace(ui=None):
    from pdb import set_trace
    QtCore.pyqtRemoveInputHook()
    set_trace()
    # QtCore.pyqtRestoreInputHook()

# This is the function that will be used to parse the input file
def parseInput(self):
    return self.path_line_edit.text()
     

class HTMLConverter(QWidget):
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self):
        super(HTMLConverter, self).__init__()

        ui_path = os.path.join(self.ROOT_DIR, 'html_converter.ui')
        loadUi(ui_path, self)
        
        self.browse_btn.clicked.connect(self.browse)

    def browse(self):
        options = QFileDialog.Options()
        options |= QFileDialog.DontUseNativeDialog
        searchPath=parseInput(self)
        file, _ = QFileDialog.getOpenFileName(self,
                                              caption='Select file',
                                              directory=searchPath,
                                              filter="Text Files (*.txt)",
                                              options=options)
        if file:
            self.file_path = file
            self.result.setText(file)
            print(file)



if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = HTMLConverter()
    window.show()
    sys.exit(app.exec_())
