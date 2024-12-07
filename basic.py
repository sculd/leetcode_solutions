from enum import Enum

class P:
    val = 4

class C(P):
    val = 6

_data_set = ['ds_basic_0']
DataSet = Enum('DataSet', {k: k for k in _data_set})

def list_dataset():
    for ds in DataSet:
        print(ds)
