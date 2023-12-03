import math

rows_num = int(input("Введіть розмір квадратної матриці: "))
lst = []
filler = input("Введіть символ-заповнювач: ")

ceil = math.ceil(rows_num / 2)
floor = rows_num - ceil

for i in range(ceil):
    lst.append([])
    for j in range(1 + i):
        if i == 3:
            lst[i].append("f")
            print(lst[i][j], end='\t')
            continue

        lst[i].append(filler)
        print(lst[i][j], end='\t')
    print()

for y in range(floor):
    lst.append([])
    space = '\t' * ceil
    print(space, end='')
    for n in range(y + 1):
        lst[floor + y].append(filler)
        print(lst[floor + y][n], end='\t')
    print()
