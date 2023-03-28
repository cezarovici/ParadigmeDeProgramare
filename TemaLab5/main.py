import os
import sys
import markdown
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

def convertToHTML(self):
    return markdown.markdown(self)
     

class HTMLConverter(QWidget):
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self):
        super(HTMLConverter, self).__init__()

        ui_path = os.path.join(self.ROOT_DIR, 'html_converter.ui')
        loadUi(ui_path, self)
        
        self.browse_btn.clicked.connect(self.browse)
        self.convert_btn.clicked.connect(self.convert)

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
            f=open(file, 'r')
            text=f.read()
            self.result.setText("The text is in memory, click convert")
            self.text = text
            f.close();
    
    def convert(self):
        self.result.setText(convertToHTML(self.text))
        

if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = HTMLConverter()
    window.show()
    sys.exit(app.exec_())