# spring
This repository is about core of spring , unitTest(Junit,mock,TDD) and spring JDBC

    * The IoC Container
        * xml-config (bean,alias,collection,factory-method,DI,constructor-arg,
        prototype scope,factory-bean, p-namespace ,depends-on,init-method, destroy-method)
        * annotation-config(@Configuration,@ComponentScan,@Bean,@Scope,@Description,@Component,
        @PropertySource,@Value,@Service,@Autowired,@Primary,@PostConstruct,@PreDestroy)
        * via use @Profile can define config for a group of bean like
        can difine datasource for develop and product and use 
    
    *  SpEL (Arithmetic Operators,Relational and Logical Operators,Conditional Operators)
    use @Value

    * Spring AOP (@EnableAspectJAutoProxy , @Aspect , @Before , @After , @AfterReturnin , @AfterThrowing , @Pointcut , @Around)
    Logger class for example and describe
    or spring-aop-diagram.jpg
 
    * Spring Test
        * Junit (@RunWith , @ContextConfiguration , @FixMethodOrder ,
         @BeforeClass , @AfterClass , @Before , @After , @Test ,  @Ignore)
         Assert (assertEquals,assertSame,assertNotSame,assertNotNull,assertNull, assertTrue,assertArrayEquals)
        
        * TDD test
        
        * mockito test (@RunWith(MockitoJUnitRunner.class), @InjectMocks,@Mock,mock method,when().thenReturn(),anyLong(),@Spy
        given().willReturn(),spy())
        
    * spring JDBC(DriverManagerDataSource class for create datasource ,
     JdbcTemplate class(execute,update,query),
     use RowMapper for get DB records and set in java objects and us in jdbcTemplate
    , this class is similar to prepareStatment in JAVA JDBC)
