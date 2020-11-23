# 一、类的设计

## 1.类的说明

1.1Matrix类：普通矩阵

1.2SquareMatrix类：方阵

1.3IdentityMatrix类：单位矩阵

1.4DiagonalMatrix类：对角矩阵

1.5TriangularMatrix类：上/下三角矩阵


# 二、类的成员函数以及属性说明

## 1.类的属性说明

1.1Matrix类

|属性名|属性类型|属性含义|
|---|---|---|
|Row |int	|矩阵的行数
|Column	|int	|矩阵的列数
|matrix	|double[][]	|矩阵的数据|



## 2.类的成员函数说明

2.1Matrix类

| 类名           | Matrix   |                     |                                                                                    |
|----------------|----------|---------------------|------------------------------------------------------------------------------------|
| 成员函数名     | 返回值   | 参数                | 作用                                                                               |
| Matrix         | null     | null                | 无参数构造函数                                                                     |
| Matrix         | null     | int Row, int Column | 带参构造函数，初始化矩阵行列                                                       |
| Matrix         | null     | Matrix p            | 带参构造函数，根据参数初始化矩阵所有数据                                           |
| Input          | void     | null                | 输入矩阵数据                                                                       |
| Output         | void     | null                | 输出矩阵数据                                                                       |
| Transpose      | Matrix   | null                | 返回当前矩阵的转置矩阵                                                             |
| Addition       | Matrix   | Matrix p            | 与参数矩阵进行矩阵加法，并把结果以矩阵的形式返回                                   |
| Multiplication | Matrix   | Matrix p            | 与参数矩阵进行矩阵乘法，并把结果以矩阵的形式返回                                   |
| Inverse        | Matrix   | null                | 若该矩阵是方阵，则创建方阵的对象，调用方阵中的此函数，反之则输出错误信息并返回null |
| Determeinant   | double   | null                | 若该矩阵是方阵，则创建方阵的对象，调用方阵中的此函数，反之则输出错误信息并返回null |
| Rank           | int      | null                | 求该矩阵的秩                                                                       |
| Solve          | double[] | null                | 求用该矩阵表达的线性方程组的解                                                     |



2.2SquareMatrix类

| 类名                | SquareMatrix |                              |                                                  |
|---------------------|--------------|------------------------------|--------------------------------------------------|
| 成员函数名          | 返回值       | 参数                         | 作用                                             |
| SquareMatrix        | null         | null                         | 无参数构造函数                                   |
| SquareMatrix        | null         | int Row                      | 带参构造函数，初始化方阵行列                     |
| SquareMatrix        | null         | Matrix a                     | 带参构造函数，根据参数初始化方阵所有数据         |
| CheckDiagonalMatrix | boolean      | null                         | 检测此矩阵是否是对角矩阵                         |
| CheckTriangleMatrix | int          | null                         | 检测此矩阵是否是三角矩阵                         |
| Create              | SquareMatrix | int i, int j, SquareMatrix M | 对于矩阵M返回一个以M为基础的第i行和第j列的余子式 |
| Determeinant        | double       | null                         | 计算方阵的行列式的值                             |
| Inverse             | Matrix       | null                         | 计算方阵的逆矩阵                                 |

2.3IdentityMatrix类

| 类名           | IdentityMatrix |          |                                          |
|----------------|----------------|----------|------------------------------------------|
| 成员函数名     | 返回值         | 参数     | 作用                                     |
| IdentityMatrix | null           | null     | 无参数构造函数                           |
| IdentityMatrix | null           | int Row  | 带参构造函数，初始化矩阵行列             |
| IdentityMatrix | null           | Matrix a | 带参构造函数，根据参数初始化矩阵所有数据 |
| Determeinant   | double         | null     | 计算方阵的行列式的值                     |

2.4DiagonalMatrix类

| 类名                | DiagonalMatrix |          |                                          |
|---------------------|----------------|----------|------------------------------------------|
| 成员函数名          | 返回值         | 参数     | 作用                                     |
| DiagonalMatrix      | null           | null     | 无参数构造函数                           |
| DiagonalMatrix      | null           | int Row  | 带参构造函数，初始化矩阵行列             |
| DiagonalMatrix      | null           | Matrix a | 带参构造函数，根据参数初始化矩阵所有数据 |
| Determeinant        | double         | null     | 计算方阵的行列式的值                     |
| CheckDiagonalMatrix | boolean        | null     | 检测矩阵时候是对角矩阵                   |



2.5TriangularMatrix类

| 类名             | TriangularMatrix |          |                                          |
|------------------|------------------|----------|------------------------------------------|
| 成员函数名       | 返回值           | 参数     | 作用                                     |
| TriangularMatrix | null             | null     | 无参数构造函数                           |
| TriangularMatrix | null             | int Row  | 带参构造函数，初始化矩阵行列             |
| TriangularMatrix | null             | Matrix a | 带参构造函数，根据参数初始化矩阵所有数据 |
| Determeinant     | double           | null     | 计算方阵的行列式的值                     |




# 三、接口说明

## 1.接口名 Calculate

## 2.接口详情

| 接口名         | Calculate |          |                |
|----------------|-----------|----------|----------------|
| 函数名         | 返回值    | 参数     | 作用           |
| Addition       | Matrix    | Matrix p | 矩阵加法的接口 |
| Multiplication | Matrix    | Matrix p | 矩阵乘法的接口 |
| Inverse        | Matrix    | null     | 求矩阵的接口   |
| Determeinant   | double    | null     | 求行列式的接口 |



# 四、功能说明

## 1.初始化矩阵

按照显示的信息初始化一个主矩阵，此后的计算大多围绕这个主矩阵进行

## 2.菜单界面

显示功能菜单

## 3.更新矩阵

对主矩阵信息进行更新修改并且显示更新后的矩阵

## 4.输出矩阵

输出当前的矩阵

## 5.矩阵转置

对矩阵做转置操作，并显示转置矩阵

## 6.矩阵加法

进行矩阵的加法，如果数据合法就输出结果，不合法就输出错误信息
	
## 7.矩阵乘法

进行矩阵的乘法，如果数据合法就输出结果，不合法就输出错误信息
	
## 8.矩阵的秩

计算矩阵的秩并输出

## 9.矩阵的行列式的值

计算行列式的值并输出，中间还会输出余子式是否是特殊矩阵

## 10.矩阵的逆

计算矩阵的逆并输出

## 11.求解线性方程组

## 12.文件读写

所有的操作记录和相关结果会存储在源程序下的log.txt文件中

