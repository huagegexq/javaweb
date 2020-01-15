#单表
#1.查找部门30中员工的详细信息。
SELECT * FROM emp WHERE deptno = 30;

#2.找出从事clerk工作的员工的编号、姓名、部门号。
SELECT * FROM emp WHERE job='clerk';
SELECT empno,ename,deptno FROM emp WHERE job='clerk';

#3.检索出奖金多于基本工资的员工信息。
SELECT * FROM emp WHERE comm > sal;

#4.检索出奖金多于基本工资60%的员工信息。
SELECT * FROM emp WHERE comm > sal * 0.6;

#5.找出10部门的经理、20部门的职员 的员工信息。
SELECT * FROM emp WHERE deptno=10 AND job='MANAGER' OR deptno=20 AND job='CLERK';

#6.找出10部门的经理、20部门的职员 或者既不是经理也不是职员但是工资高于2000元的员工信息。
SELECT * FROM emp
   WHERE deptno=10 AND job='manager' OR
         deptno=20 AND job='clerk' OR
         job!='manager' AND job!='clerk' AND sal > 2000;
         
#7.找出获得奖金的员工的工作。
SELECT job FROM emp WHERE comm IS NOT NULL;
SELECT job FROM emp WHERE comm > 0;

SELECT * FROM emp WHERE comm > 0;


#8.找出奖金少于100或者没有获得奖金的员工的信息。
SELECT * FROM emp WHERE comm < 100 OR comm IS NULL;

#9.找出姓名以A、B、S开始的员工信息。
SELECT * FROM emp WHERE ename LIKE 'A%' OR ename LIKE 'B%' OR ename LIKE 'S%';

#10.找到名字长度为6个字符的员工信息。
SELECT * FROM emp WHERE ename LIKE '______';
SELECT * FROM emp WHERE LENGTH(ename) = 6;

#11.名字中不包含R字符的员工信息
SELECT * FROM emp WHERE ename LIKE '%R%';
SELECT * FROM emp WHERE ename NOT LIKE '%R%';

#12.返回员工的详细信息并按姓名排序。
SELECT * FROM emp ORDER BY ename;

#13.返回员工的信息并按工作降序工资升序排列。
SELECT * FROM emp ORDER BY job DESC;
SELECT * FROM emp ORDER BY job DESC,sal ASC;

#14.计算员工的日薪(按30天)。
SELECT ename,sal FROM emp;

SELECT ename,sal/30 AS '日薪' FROM emp;

SELECT ename,TRUNCATE(sal/30,2) AS '日薪' FROM emp;

#15.找出姓名中包含A的员工信息。
SELECT * FROM emp WHERE ename LIKE '%A%';


















