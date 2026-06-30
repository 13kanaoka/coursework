import pytest
import main
import io
import sys
import re


@pytest.mark.T1
def test_main_1():
    captureOut = io.StringIO()
    sys.stdout = captureOut
    # datastr = '40 \n 40 \n 20'
    # sys.stdin = io.StringIO(datastr)

    ret1, ret2 = main.main()
    sys.stdout = sys.__stdout__
    print('Captured ', captureOut.getvalue())
    lines = captureOut.getvalue().split('\n')
    print(lines)

    assert ret1 is not None, 'Your return value ret1 is None'

@pytest.mark.T2
def test_main_2():
    captureOut = io.StringIO()
    sys.stdout = captureOut
    # datastr = '40 \n 40 \n 20'
    # sys.stdin = io.StringIO(datastr)

    ret1, ret2 = main.main()
    sys.stdout = sys.__stdout__
    print('Captured ', captureOut.getvalue())
    lines = captureOut.getvalue().split('\n')
    print(lines)

    assert ret2 is not None, 'Your return value ret2 is None'

@pytest.mark.T3
def test_main_3():
    captureOut = io.StringIO()
    sys.stdout = captureOut
    # datastr = '40 \n 40 \n 20'
    # sys.stdin = io.StringIO(datastr)

    ret1, ret2 = main.main()
    sys.stdout = sys.__stdout__
    print('Captured ', captureOut.getvalue())
    lines = captureOut.getvalue().split('\n')
    print(lines)

    res = re.search(r'[\w,\W]*[h,H]ello[\w,\W]*[w,W]orld', ret1)
    print(res.group())
    assert res is not None, 'Expect Hello World!'


@pytest.mark.T4
def test_main_4():
    captureOut = io.StringIO()
    sys.stdout = captureOut
    # datastr = '40 \n 40 \n 20'
    # sys.stdin = io.StringIO(datastr)

    ret1, ret2 = main.main()
    sys.stdout = sys.__stdout__
    print('Captured ', captureOut.getvalue())
    lines = captureOut.getvalue().split('\n')
    print(lines)

    res = re.search(r'[\w,\W]*CS[\w,\W]*V17', ret2)
    print(res.group())
    assert res is not None, 'Expect CS V17'
