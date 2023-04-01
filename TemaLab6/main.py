import os
from GenericFile import GenericFile 

if __name__ == '__main__':
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))+"/searchDirectory"

    generic_files = []

    for root, subdirs, files in os.walk(ROOT_DIR):
        for file in os.listdir(root):
            file_path = os.path.join(root, file)
            
            if os.path.isfile(file_path):
               generic_files.append(GenericFile(file))


    # for file in generic_files:
    # print(file.info)


    print(generic_files)