package com.example.foodapp.Activity;

//hala2 la nblesh bel content provider la7 na3mel class na3ml meno extend la class esmo Contentprovider fa 7a ykoun 3ande ba3d l method bade 2a3mela overide
//2awl she badna na3mlo b heda l class badna na3el define lal uris
//2awl she bade 3aref l authority le howe l package name ta3el l app
//ba3d heek bade 3aref shwayet path le houne:
//iza kona bade 2a3mel acces la table le fe msln asme2 l food w price image..ect
//w iza kont bade 2osal l column m3yan b table m3yan la7 3aref kamen path msln asme2 l food bas
//w iza kent bde 2osal la 3adad l item le 3nade la7 est5dem kamen wa7ad
//fa hala2 3ande 3 different path kel wa7de btjeble data m3yane
//hala2 bade 2a3ml create la uri 3ande 3 uri kel wa7de b2lba 3 commponent l content:// tene component l authority telet commpoent data le m3yane esma le heye l path  :
//bas hawde l 3 uri ma la7 yetm este5demoun b class l content provider hawde l sawebet l uri la7 ytem este5demoun b wasetet l conetnt resolver la ya3mel request

//hala2 bas yseer request mn conetnt resolver best5dem hawde l uri le 3mltoun keef fena net3emal ma3 heda reqeust w nred data mn 5elelo la heek la7 nest5dem she esmo uri matcher w la7 nest3mel l medthod le mawjoude be heda l class
//hala2 hawde l uri le 3mletoun sho bade 2a3mel fehou n hawde bade 2a3mel assiociate la different dataset kel wa7de bte7mel data jdede le heye data le bel databse tab3tna bas keef la na3ml hal 7arake
//3ande api esmo uriMatcher sho heda w keef byeshte8l heda l urimatcher 3ando set of CONETNT_URI ya3ne b ma3na tene mnzeed 3lee uri fa hawde l uri le 3ande bade 7otoun b2lbo w hawde l uri bade 2a3ml maping ya3ne kel uri bade 3aber 3lee b integer  ya3ne 3ande set of intger conetarint kel wa7de bt3ber 3an content uri m3yan
//hala2 la7 nshof keef badna n3mla
//2awl she badna na3ml implement lal urimatcher
//bas 2abla badna na3mel varible contant integer hawde l contant intger kelwa7de assiciated la uri m3yan b2ab heda l contnt provider
//fa ba3mel 3 integer static final bnafs esm path w kel wa7de ba3teha integer 1,2,3
//hala2 ba3d ma 3arft l integr variable bade 2a3ml objet mn l uri matcher ba3mlo static l2no kel l value le bade 7ota fe static w b3te lal contructor eno ma bade heda lmactcher ykoun fe wala value fa b2olo bel contructor URIMatcher.No_Match
//hala2 bade 2a3ml add la hawde l integer b2lb l urimatcher w assicite them into authority and path le 3mlteloun declare 3ande
//l2no kel l value le 3ande static vlaue fa lezm 2a3mloun intilze b2lb static block fa m3mel matcher.adduri()2awl parmeter howe l suthority,tene paramter howe l path telet paramter howe l inger value le by3ml map 3ala hyda l path
//fa hala2 kel integer vlaue assiciate with specific uri
//hala2 3ande method esma gettype b2lb class l contentprovider la7  nshof keef bana nest3ml mathcer b2lbo hyda l method ana best5dema bteb3tle l uri fa be5od heda l uri bshof hal howe match ma3 wa7de mn hawde l uri mn 5elel matcher.match(uri) fa hyde btrdele integer base 3ala heda l intger bef7as iza keen integr 1 3meel she

//fa le sar hala2 badna n3ml overide 3ala method l content provider le houne:
//hawde l method mn 5e5eloun bade 2a3ml mange la databse le 3ande ya3ne iza bade zeed she food,bade 23mel dlete la she food,update she food..etc
//2awl she badna net2kad eno addpter databse 100 bel 100 sha8al w 3ande kteer method insert bas lezm zeed function lal insert le bade 3oza lal content provider le btefre2 hay l method insted of return boolean bade 2a3ml return la long w hyde l method bte5od contentvlaue object
//w nafs she bel nesbe lal delete kamen bade 2a3ml function return integer w bte5od whereclasue string,bte5od where vlaue array
//w 3ande kamn method lal update kamen bte5od contentvalue,string,w array f string
//ba3den 3ande method btrej3 cursor b2lab kel table
//w 3nade method btrje3 cursor feha column m3yan
//w 3ande method btrje3 curosor feha 3ada l rows
//oncreate:hyde l method b2lba lezm na3ml initlize la aye instance mn3oza bel conetnt provider fa houn la7 na3ml initlize la DatabseAddpter le howe databse acces l2no ne7na badna n3ouz databse la na3ml call lal method le 3mlneha ta3et l provider
//.query:hyde l method bt3mel kel retrive la data mn databse l query method bte5od 2awl argumnt l uri le howe b3ber 3an aye databset we have to return ,second argumnet howe projection l column le bade yehoun ,telet paramter l array of selection argumnet,4 paramter howe l sort oreder asec 2aw dec
//l m8za mn l mawdo3 eno bas eje la 2a3mel call la hy l method sho l uri le bade 7oto fa houn bas eje la 7ot l uri lezm shof sho howe l uri 2a3mel check la 2a3ref sho nou3 daata le bade raje3a mn 5elel l mactcher based 3ala l l matcher ta3el l uri 7asab sho berj3le vlaue integer la7 nrjae3 apropriate vlaue and inilzize it le howe l cursor w heda l cursor la7 yerja3 mn l query method
//fa ne7na bas na3ml check iza mnetzakr table taba3 l food b2lbo she 9 column fa 2awl check ta3el l matcher le how Matcher.match(uri) iza keen equll lal Foods_list bade 2a3ml intilez lal cursor w raje3 l cursor le 5aso bkel data taba3 l food
//ama iza keen equll la foodfromsepcific_lace la7 yrja3le column name
//ama iza keen food_count la7 yrj3le l cursor le fe l data 3adad rows le bel food table
//hala2 badna nblesh b method l oncreate la7 n3ref instnce mn databce acces w na3mel initlize la 2elo b method l oncreate return value taba3 hay l method boolean mn3mel return true iza 3mlna succefully inilize databseacces
//tene method hala2 l query method mn3ref curssor =null ba3den howe byeb3tlna l uri fa ne7na mn3ml check mn 5elel l matcher.check(uri) btrj3le integer taba3 heda l uri le ne7na 3arefnoun fa mnshof iza keen foodlist mn 5ale heda l cursor equll la funtion le 3rfneha bel databse le esma getcursorfoallfood w break iza la2 eza keen equlllal food_form_specific_place mn5le l cursor equll la getcursoratspecificpostion w iza keen equll lal food_count mn5le l cursor equll lal getcursorcount w ba3den mn3mel retun lal cursor
//insert:insert data b2alb databse btraje3 uri
//delete:delete kamen hyde l method bt3mel delete la row 7a nest5dem method delete le mawjoude bel databse acces btrje3 integer le howe 3ada l rows l n3mloun delete
//update:update same kamen l deleete mnest5dem method l update le mawjoude bel databse btrje3 integer 3ada l row le n3mloun updste bte5od method l update uri,contentvalue,where,wherevlaues
//gettype

//insetmethod 3nada uri parameter ,w content vlaue hyde l method momken traje3 exeption esmo unsupportoperationexeption aymta btrje3 exeption iza keen l uri le b3teto ma byetba2 ma3 aye wa7d bel content provider bt3mel exeption
//la7 na3ml method esa insetfood bte5od uri,w conetntvalue hyde l method 2awl she la7 nest5dem method ta3et database l inset fa 7a trjel3e long id heda l id la7nnest5dmo la nraje3 uri le howe l contain authority w path w plus l id 3ashn nraje3 kel mara bt3mel inserd uri jdeed bas la heda row

//tene method l delete hyde brje3 3adad row le n3mlo delete la7 2a3ml method kamen hala2 retun integer bte5od whereclause,array of sting w b2lba mn3mel retun la method delete le bel database w mn3teha l whereclause w wherevlaues w l update nafs she
//hala2 ne7na 5alsna kel lmethod ta2rebn ba3d 3ana bas method wa7de le heye l gettype:
//2awl she lesh mnest3mel hay l method?
//hala2 bas na3ml implemntation la app2 le badna neb3tla data mn l app1 la app2
//app2 lezm ta3ref sho nou3 data le 3am tenbe3et mn app1 lesh l2no nou3 data le 3am tenba3t mn l app1 momken tkoun naw3a aye she bel 3alam momken btrje3 rows w column mn databse 2aw momken tkoun btrje3 keme wa7de metl l count number of row lahek l mwdo3 keen eno getype() w bt3etha l uri contentresolver.getype(uri) so2al sho btrje3 hay l function btrje3 string enta bt3te l uri then l content provider btrje3lk bt2olak hyda nou3 datatype taba3 hyda l uri
//hala2 nou3 datatype byotlo2o 3lee she esmo mimi type le howe e5tesar la multiple internet mail exetntion momken ykoun htm,json,dpf le howe content provider byest3ml uri le howe similar to url le bekoun msln htm/text,json/application,pdf,application hyde l way bt5le l browser ya3ref keef bado yet3emal ma3 data le jeye mn serverside
//fa bnfs tare2a contentprovider byet3yan 3lee y2oloun same7 eloun ma3refet sho nou3 datatype le 3am yebe3t mn application tene
//b7ded l cotent provider bshakl asese 3 anwe3 mn l type ta3et data,btem est5dem CURSOR_DIR_BASE_TYPE lel 2eshara iza kent 3am traje3 zero 2aw aktar mn eme bte7twe 3al rows w column mn databse
//btem est5dem CURSOR_ITME_BASE_TYPE:bas badak trjae3 2eme wa7de bas
//l ANY_CURSOR_ITEM_TYPE:heda 3ebra 3an application dependent content ya3ne heda 3ebra 3an l uri lal mo7tawa le bye3temed bshakl kbeer 3ala l application.7ata law ma kent 3am teshte8l ma3 no3 l mimime le be2om berje3 nou3 data mo5asase fa 8eer heek ma 7a test5dmo la heda type ela iza keen nou3 costumize datatype

//CURSOR_DIR_BASE_TYPE="vnd.android.cursor.dir";
//CURSOR_ITEM_BASE_TYPE="vnd.android.cursor.itm"
//sho ya3ne vnd ya3ne l be2e3 vender
//so2al hala2 keef bade 7aded nou3 l mimi type taba3 l application l mo5asas ele how to create costom mime type?
//android 3atetna ba3d l ektera7et:
//bt2olk 2awl she 3atoul balesh b she esmo "vnd"
//ba3den 3meel dot w ktob 7edo bshkl ma2lom esm package l domain name
//w 2e5er she 3meel dot w 7ot aye string badak yeh
//w ba3den 3aref varible w 3meel concatination ma3 l cursor_dir_type ya3ne CURSOR_DIR_TYPE+"/"+"vnd.codutor.tods" w heda le 7 nraj3o be method l gettype
//fa hala2 la7 na3mel implemnt
//la7 n3ref 3 string mimitype1,2,3 w na3mel la kel wa7de l mimitype w method l getype howe byeb3tle l uri ba3mel check w ba3ml return lal mimitype 7asab ya3ne iza keen l ched food_list be3tlo l mimitype l 5as bel food_list bas badna nentbh bas nraje3 eme wa7de metl count badna nest3mel l mimitype cursor_item_base_type
//hala2 l getype mana callback method metl oncreate btem ested3e2a 2awl ma nenshe2 l content provider la2 heye btestd3a  yadaweyan metl add,delete,update

//hala2 e5er she bas n5les badna nsjel l contentprovider bel manifist keef mn3mel:<provider
//            android:authorities="com.example.foodapp"
//            android:name=".Activity.DeliveryAppProvider"
//            android:exported="false"/
//2awl wa7d howe l authorites metl howe esm la hyde ya3ne ta7t aye 3enwen nbadna nl2e bel content provider fa mn3te aye she bas 5le ykoun com.khaled.dndf aye she esm bas google btrshe7 heek ykoun com.example.foodapp.Activity.DeliveryAppProvider  ya3ne l path taba3 l class
//w tene w7de name howe esm l class
//w e5er she eno exported fe application tenye test5dmo
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodapp.Database.DatabaseAcces;

public class DeliveryAppProvider extends ContentProvider {

    public static final String AUTHORITY="com.example.foodapp";
    public static final String PATH_FOOD_LIST="FOOD_LIST";
    public static final String PATH_FOOD_PLACE="FOOD_LIST_FORM_PLACE";
    public static final String PATH_FOOD_COUNT="FOOD_COUNT";

    public static final Uri CONTENT_URI_1=Uri.parse("content://"+AUTHORITY+"/"+PATH_FOOD_LIST);
    public static final Uri CONTENT_URI_2=Uri.parse("content://"+AUTHORITY+"/"+PATH_FOOD_PLACE);
    public static final Uri CONTENT_URI_3=Uri.parse("content://"+AUTHORITY+"/"+PATH_FOOD_COUNT);

    public static final int FOOD_LIST=1;
    public static final int FOOD_FROM_SPECIFIC_PLACE=2;
    public static final int FOOD_COUNT=3;

    private static final UriMatcher MATCHER=new UriMatcher(UriMatcher.NO_MATCH);

    static{
        MATCHER.addURI(AUTHORITY,PATH_FOOD_LIST,FOOD_LIST);
        MATCHER.addURI(AUTHORITY,PATH_FOOD_PLACE,FOOD_FROM_SPECIFIC_PLACE);
        MATCHER.addURI(AUTHORITY,PATH_FOOD_COUNT,FOOD_COUNT);
    }

    public static final String MIMETYPE_1= ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+"vnd.com.example.foodapp.allfood";
    public static final String MIMETYPE_2= ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+"vnd.com.example.foodapp.specialfood";
    public static final String MIMETYPE_3= ContentResolver.CURSOR_ITEM_BASE_TYPE+"/"+"vnd.com.example.foodapp.countfood";


    private DatabaseAcces databaseAcces;
    @Override
    public boolean onCreate() {
        databaseAcces=DatabaseAcces.getInstance(getContext());
        return true;

    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor=null;
        switch (MATCHER.match(uri)){
            case FOOD_LIST:cursor=databaseAcces.getCursorForAllFood();
            break;
            case FOOD_FROM_SPECIFIC_PLACE:cursor=databaseAcces.getCursorForSpecificPlace(projection[0]);
            break;
            case FOOD_COUNT:cursor=databaseAcces.getCursorCount();
            break;
            default:cursor=null;
            break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (MATCHER.match(uri)){
            case FOOD_LIST:return MIMETYPE_1;
            case FOOD_FROM_SPECIFIC_PLACE:return MIMETYPE_2;
            case FOOD_COUNT:return MIMETYPE_3;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Uri returnuri=null;
        switch (MATCHER.match(uri)){
            case FOOD_LIST:returnuri=insertfood(uri,values);
            break;
            default:new UnsupportedOperationException("insert operation not supported");
            break;
        }
        return returnuri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int deletecount=-1;
        switch (MATCHER.match(uri)){
            case FOOD_LIST:deletecount=deletefood(selection,selectionArgs);
            break;
            default:new UnsupportedOperationException("insert operation not supported");
            break;
        }
        return deletecount;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int updatecount=-1;
        switch (MATCHER.match(uri)){
            case FOOD_LIST:updatecount=updatefood(values,selection,selectionArgs);
            break;
            default:new UnsupportedOperationException("insert operation not supported");
            break;

        }
        return updatecount;

    }

    private Uri insertfood(Uri uri,ContentValues contentValues){
        long id=databaseAcces.insertprovider(contentValues);
        getContext().getContentResolver().notifyChange(uri,null);
        return Uri.parse("content://"+AUTHORITY+"/"+PATH_FOOD_LIST+"/"+id);
    }

    private int deletefood(String whereclause,String[] whereValues){
        return databaseAcces.Deleteprovider(whereclause,whereValues);
    }

    private int updatefood(ContentValues contentValues,String whereClause,String[] strings){
        return databaseAcces.updateprovider(contentValues,whereClause,strings);
    }
}
