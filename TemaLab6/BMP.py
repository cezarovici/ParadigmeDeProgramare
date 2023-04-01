import Binary

class BMP(Binary):
    width = None
    height = None
    bpp = None

    def show_info(self):
        return "\nWidth = "+self.width+"\nHeight = "+self.height+"\nBpp = "+self.bpp