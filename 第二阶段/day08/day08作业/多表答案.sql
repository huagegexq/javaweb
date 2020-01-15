#多表
#1.返回拥有员工的部门名、部门号。
SELECT DISTINCT d.dname,d.deptno FROM dept d ,emp e WHERE d.deptno = e.deptno;

#2.工资水平多于smith的员工信息。
SELECT sal FROM emp WHERE ename = 'smith';
SELECT * FROM emp WHERE sal>800;
SELECT * FROM emp WHERE sal> (SELECT sal FROM emp WHERE ename = 'smith') ;


#3.返回员工和所属经理的姓名。
SELECT e.ename,m.ename FROM emp e,emp m WHERE e.mgr=m.empno;

SELECT e.ename,m.ename FROM emp e
  LEFT OUTER JOIN emp m ON e.mgr=m.empno;

#4.返回雇员的雇佣日期早于其经理雇佣日期的员工及其经理姓名
SELECT e.ename,m.ename 
  FROM emp e,emp m 
  WHERE e.mgr=m.empno AND e.hiredate < m.hiredate;

#5.返回员工姓名及其所在的部门名称。
SELECT e.ename,d.dname FROM emp e,dept d WHERE e.deptno = d.deptno;

#6.返回从事clerk工作的员工姓名和所在部门名称。
SELECT e.ename,d.dname FROM emp e,dept d WHERE e.deptno = d.deptno AND e.job='clerk';

#7.返回部门号及其本部门的最低工资。
SELECT deptno,MIN(sal) FROM emp GROUP BY deptno

#8.返回销售部(sales)所有员工的姓名。
SELECT deptno FROM dept WHERE dname='sales';
SELECT * FROM emp WHERE deptno = 30;
SELECT ename FROM emp WHERE deptno = (SELECT deptno FROM dept WHERE dname='sales');


#9.返回工资水平多于平均工资的员工。
SELECT * FROM emp WHERE sal > (SELECT AVG(sal) FROM emp);

#10.返回与SCOTT从事相同工作的员工。
SELECT job FROM emp WHERE ename='scott';
SELECT * FROM emp WHERE job = (SELECT job FROM emp WHERE ename='scott');

SELECT * FROM emp WHERE ename='scott';
SELECT * FROM emp e1 , (SELECT * FROM emp WHERE ename='scott') e2 
   WHERE e1.job = e2.job AND e1.empno != e2.empno;


#11.返回与30部门员工工资水平相同的员工姓名与工资。
SELECT ename,sal FROM emp WHERE sal IN (SELECT sal FROM emp WHERE deptno=30);

#12.返回工资高于30部门所有员工工资水平的员工信息。
SELECT * FROM emp WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno=30);

#13.返回部门号、部门名、部门所在位置及其每个部门的员工总数。
SELECT d.deptno,d.dname,d.loc,COUNT(*) FROM dept d , emp e WHERE d.deptno = e.deptno GROUP BY d.deptno;

#14.返回员工的姓名、所在部门名及其工资。
SELECT e.ename,d.dname,e.sal FROM dept d ,emp e WHERE d.deptno = e.deptno;

#15.返回员工的详细信息。(包括部门名)
SELECT e.* , d.dname FROM emp e , dept d WHERE d.deptno=e.deptno;


