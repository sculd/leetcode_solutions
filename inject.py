from enum import Enum
import basic

def print_val(self):
    print(f'{self.val=}')

basic.P.print_val = print_val

_basic_data_set = {ds.name: ds.value for ds in basic.DataSet}
_data_set = ['ds_inject_0']
#basic.DataSet = Enum('DataSet', {**_basic_data_set, **{k: k for k in _data_set}})

from aenum import extend_enum
for k in _data_set:
    extend_enum(basic.DataSet, k, k)
    pass