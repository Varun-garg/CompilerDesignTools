����   4
 < v	  w
 # x
 # y z	  {	  {
 | }	  ~
 | 
 | �
 � �	  �
 � �
 # �
 � �
 � �
 # �   � � � � �
 � � �	 � � �
  v �
  � �
  �
 � �
 � �
 ; �
 # � �
 # v � �	 � �
 & �
 % � � � �
 � �
 % �
 � � �
 | � �
 | �
  v  �
 � �
  v � �
  � � � 	FirstItem InnerClasses 
Production <init> ()V Code LineNumberTable LocalVariableTable this LFirst; CalculateFirst >(Ljava/util/ArrayList;Ljava/util/ArrayList;LFirst$FirstItem;)V 
firstChStr Ljava/lang/String; nextFirstItem LFirst$FirstItem; 
expression 	firstChar C i I productions Ljava/util/ArrayList; UniqueNonTerminals 	firstItem LocalVariableTypeTable )Ljava/util/ArrayList<LFirst$Production;>; (Ljava/util/ArrayList<LFirst$FirstItem;>; StackMapTable � � � 	Signature e(Ljava/util/ArrayList<LFirst$Production;>;Ljava/util/ArrayList<LFirst$FirstItem;>;LFirst$FirstItem;)V main ([Ljava/lang/String;)V arr [Ljava/lang/String; 
production LFirst$Production; input args n br Ljava/io/BufferedReader; b � z 
Exceptions � lambda$main$1 '(LFirst$Production;LFirst$Production;)Z o lambda$CalculateFirst$0 &(Ljava/lang/String;LFirst$FirstItem;)Z 
SourceFile 
First.java @ A � � � � � � First$Production � J � � � � J � � � � � � � � S � � � � � � � � � � BootstrapMethods � � � � � � � � � � � � � � First$FirstItem � � � java/lang/StringBuilder Found Non Terminal  � �  without any derivation � � � � � � � G H � � java/util/ArrayList java/io/BufferedReader java/io/InputStreamReader � � @ � @ � 6Enter productions in form S -> Sb, @ for Epsilon/null. DInstead of using S -> Sb / d, enter 2 productions s -> Sb and S -> d Enter no of productions	: � � � � � � � Enter productions � � -> � � � � � � � � /First for following Non Terminals is as follows  : 	 �  First java/lang/Object java/lang/String java/io/IOException FirstCalculated Z size ()I get (I)Ljava/lang/Object; NonTerminal equals (Ljava/lang/Object;)Z 
Expression length charAt (I)C java/lang/Character isLowerCase (C)Z valueOf (C)Ljava/lang/Character; add isUpperCase toString (C)Ljava/lang/String; stream ()Ljava/util/stream/Stream;

 ; (LFirst$FirstItem;)Z test 2(Ljava/lang/String;)Ljava/util/function/Predicate; java/util/stream/Stream filter 9(Ljava/util/function/Predicate;)Ljava/util/stream/Stream; 	findFirst ()Ljava/util/Optional; java/util/Optional orElse &(Ljava/lang/Object;)Ljava/lang/Object; java/lang/System out Ljava/io/PrintStream; append -(Ljava/lang/String;)Ljava/lang/StringBuilder; ()Ljava/lang/String; java/io/PrintStream println (Ljava/lang/String;)V exit (I)V addAll (Ljava/util/Collection;)Z in Ljava/io/InputStream; (Ljava/io/InputStream;)V (Ljava/io/Reader;)V print readLine java/lang/Integer parseInt (Ljava/lang/String;)I trim split '(Ljava/lang/String;)[Ljava/lang/String;
 ; (LFirst$Production;)Z 2(LFirst$Production;)Ljava/util/function/Predicate; 	isPresent ()Z -(Ljava/lang/Object;)Ljava/lang/StringBuilder;	 r s o p "java/lang/invoke/LambdaMetafactory metafactory Lookup �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; %java/lang/invoke/MethodHandles$Lookup java/lang/invoke/MethodHandles ! ; <       @ A  B   /     *� �    C        D        E F   	 G H  B       �,� � �>*� � �*� � � ,� � � � �*� � � 	:� 
� � �� 6� � 
@� ,� � � W� � l� :+� �   �  �  � � :� &� � Y� � � � � � �  � � 
*+� !,� � � "W���0,� �    C   b           '  *  7  ?  B ! J # Y $ f & n ' u ( � ) � + � , � - � 0 � 1 � 3 �  � 6 � 7 D   R  u b I J  � D K L  7 � M J  J � N O  
 � P Q    � R S     � T S    � U L  V       � R W     � T X  Y   1 
� �  Z� � T Z [�   \ \ [  �  ]    ^ 	 _ `  B  �  
  K� #Y� $L� #Y� $M� %Y� &Y� '� (� ):� *� � +� � ,� -� .� /6� 0� 6� �� .N-� 12� 3:� Y� 4:2� 1� 2� 1� 	+� � 5  �  �  � 6� /� Y� 7:		� � 	� #Y� $� 	� ,	� W+� W���v6,� � +,,� � � !���� 8� 6,� � <� � Y� ,� � � � 9� ,� � � � :� � �����    C   z    :  ;  @ # A + B 3 C ; D E F M G W H ] I h J q K } L � M � N � O � P � Q � R � T � G � W � X � W � Z \ ]D \J ^ D   z  � # U L 	 h o a b  q f c d  ] � e J  P � P Q  �  P Q  B P Q   K f b   C R S  ; T S  E g Q  #( h i  V     C R W  ; T X  Y   Y � P  j \ \  k  �  	 j \ \ Z k j l  �   j \ \  k  � � � 
� A m     n
 o p  B   @     +� *� � �    C       M D        c d      q d 
 r s  B   E     	+� *� �    C       (  )  ( D       	 I J     	 q L   t    u >      ; = 	  ; ? 	
  �     �  � � � �  � � �                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      