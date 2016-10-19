function RatingObject()
{
	this.JSON = {Index:"",X:"",Y:"",ParentElement:"",Size:"", Ratio:"",Opacity:"",Angle:"",Rating:"",Type:""};

	this.GetX =  function(){ return this.JSON.X };
	this.SetX =  function( input ){ this.JSON.X = input };

	this.GetY =  function(){ return this.JSON.Y };
	this.SetY =  function( input ){ this.JSON.Y = input };

	this.GetParentElement =  function(){ return this.JSON.ParentElement };
	this.SetParentElement =  function( input ){ this.JSON.ParentElement = input };

	this.GetIndex =  function(){ return this.JSON.Index };
	this.SetIndex =  function( input ){ this.JSON.Index = input };

	// this.GetMode =  function(){ return this.JSON.Mode };
	// this.SetMode =  function( input ){ this.JSON.Mode = input };

	this.GetSize =  function(){ return this.JSON.Size };
	this.SetSize =  function( input ){ this.JSON.Size = input };

	this.GetRatio =  function(){ return this.JSON.Ratio };
	this.SetRatio =  function( input ){ this.JSON.Ratio = input };

	this.GetOpacity =  function(){ return this.JSON.Opacity };
	this.SetOpacity =  function(input){ this.JSON.Opacity = input };

	this.GetAngle =  function(){ return this.JSON.Angle };
	this.SetAngle =  function(input){ this.JSON.Angle = input };

	this.GetType =  function(){ return this.JSON.Type };
	this.SetType =  function(input){ this.JSON.Type = input };

	this.Constructor = function( Index, X , Y , ParentElement , Size, Ratio, Opacity , Angle, Type, Rating)
	{
		this.SetIndex( Index );
		this.SetX( X );
		this.SetY( Y );
		this.SetParentElement( ParentElement );
		this.SetSize( Size );
		this.SetRatio( Ratio );
		this.SetOpacity( Opacity );
		this.SetAngle( Angle );
		this.SetType( Type );
		this.JSON.Rating = Rating;
		
		this.Draw(this);
	}
 
 	var col;
 	var col1;
	
	this.Draw = function(Object)
	{
		var colr = $( "#"+Object.GetParentElement()+"" ).css("background-color");

		//col = ColorWithFactor(colr, -60);
		col = "rgb(128,0,0)";
		/*col1 = ColorWithFactor(colr, -60);
*/	col1="rgb(188,188,0)";
		Object.Base_Div = 	
					"<div id='Base_Div"+Object.GetIndex()+"' style='position: relative; top: "+Object.GetY()+"px; left: "+Object.GetX()+"px; width: "+Object.GetSize()+"px; height: "+Object.GetSize()/Object.GetRatio()+"px; opacity: "+Object.GetOpacity()+"; transform: ("+Object.GetAngle()+"deg); border: 0px solid rgb(242,61,4); background-color: transparent;z-index:5;border-radius:60px 60px 60px 60px;box-shadow:1px 1px 10px "+col+";'></div>"

		$( "#"+Object.GetParentElement()+"" ).append(Object.Base_Div);

		var k = Object.GetSize()/Object.GetRatio();
		var l = Object.GetSize();


			Object.Rating_1 = "<div id='Rating_1"+Object.GetIndex()+"'>1</div>";
			$( "#Base_Div"+Object.GetIndex()+"" ).append(Object.Rating_1);
			$( "#Rating_1"+Object.GetIndex()+"" ).css( {"position":"absolute","top":"30%","left":(0.1*l)+"px","height":"40%","width":0.4*k+"px","background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","font-size":"16px","border-radius":"100%","font-weight":"bold","text-align":"center","transform":"rotate(0deg)","box-shadow":"1px 1px 5px "+col,"line-height":0.4*k+"px","cursor":"default"});

			Object.Rating_2 = "<div id='Rating_2"+Object.GetIndex()+"'>2</div>";
			$( "#Base_Div"+Object.GetIndex()+"" ).append(Object.Rating_2);
			$( "#Rating_2"+Object.GetIndex()+"" ).css( {"position":"absolute","top":"30%","left":(0.1*l+0.4*k+0.1*l)+"px","height":"40%","width":0.4*k+"px","background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","font-size":"16px","border-radius":"100%","font-weight":"bold","text-align":"center","transform":"rotate(0deg)","box-shadow":"1px 1px 5px "+col,"line-height":0.4*k+"px","cursor":"default"});

			Object.Rating_3 = "<div id='Rating_3"+Object.GetIndex()+"'>3</div>";
			$( "#Base_Div"+Object.GetIndex()+"" ).append(Object.Rating_3);
			$( "#Rating_3"+Object.GetIndex()+"" ).css( {"position":"absolute","top":"30%","left":(0.1*l+0.4*k+0.1*l+0.4*k+0.1*l)+"px","height":"40%","width":0.4*k+"px","background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","font-size":"16px","border-radius":"100%","font-weight":"bold","text-align":"center","transform":"rotate(0deg)","box-shadow":"1px 1px 5px "+col,"line-height":0.4*k+"px","cursor":"default"});

			Object.Rating_4 = "<div id='Rating_4"+Object.GetIndex()+"'>4</div>";
			$( "#Base_Div"+Object.GetIndex()+"" ).append(Object.Rating_4);
			$( "#Rating_4"+Object.GetIndex()+"" ).css( {"position":"absolute","top":"30%","left":(0.1*l+0.4*k+0.1*l+0.4*k+0.1*l+0.4*k+0.1*l)+"px","height":"40%","width":0.4*k+"px","background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","font-size":"16px","border-radius":"100%","font-weight":"bold","text-align":"center","transform":"rotate(0deg)","box-shadow":"1px 1px 5px "+col,"line-height":0.4*k+"px","cursor":"default"});

			Object.Rating_5 = "<div id='Rating_5"+Object.GetIndex()+"'>5</div>";
			$( "#Base_Div"+Object.GetIndex()+"" ).append(Object.Rating_5);
			$( "#Rating_5"+Object.GetIndex()+"" ).css( {"position":"absolute","top":"30%","left":(0.1*l+0.4*k+0.1*l+0.4*k+0.1*l+0.4*k+0.1*l+0.4*k+0.1*l)+"px","height":"40%","width":0.4*k+"px","background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","font-size":"16px","border-radius":"100%","font-weight":"bold","text-align":"center","transform":"rotate(0deg)","box-shadow":"1px 1px 5px "+col,"line-height":0.4*k+"px","cursor":"default"});
			//width not set in json after updation

			$( "#Base_Div"+Object.GetIndex()+"" ).css({"width":(0.1*l+0.4*k+0.1*l+0.4*k+0.1*l+0.4*k+0.1*l+0.4*k+0.1*l+0.4*k+0.1*l)+"px"});
		
					
		if(Object.GetType() == "Editable")
		{
			Object.ResetRating = "<div id='ResetRating"+Object.GetIndex()+"'>Reset</div>";
			$( "#Base_Div"+Object.GetIndex()+"" ).append(Object.ResetRating);
			$( "#ResetRating"+Object.GetIndex()+"" ).css( {"position":"absolute","top":"-10%","left":"30px","height":"25%","width":0.8*k+"px","background-color": "#FFFFFF","border":"0px solid rgb(145,141,2)", "color": col1+"","font-size":"10px","border-radius":"10px","font-weight":"none","text-align":"center","transform":"rotate(0deg)","box-shadow":"1px 1px 5px "+col,"line-height":0.25*k+"px","cursor":"default","visibility":"hidden"});

			var k = Object.JSON.Rating;
				for(var i=1;i<=k;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				}

			Object.EventHandlers(Object);
		}
		else
		{
			var k = Object.JSON.Rating;
				for(var i=1;i<=k;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				}
		}
	}

	this.SetFlag = true;

	this.EventHandlers = function(Object)
	{
		$( "#ResetRating"+Object.GetIndex() ).on('mouseover',function(){ $( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); });
		$( "#ResetRating"+Object.GetIndex() ).on('mouseout',function(){ $( this ).css( {"background-color": "#FFFFFF","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col}); });

		$( "#ResetRating"+Object.GetIndex() ).on('click',function()
		{
		
			$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_5"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			Object.JSON.Rating = 0;

			Object.SetFlag = true;
			
			
			document.getElementById("userRating").value=0;
			
			

			$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"hidden"});
		});

		$( "#Rating_1"+Object.GetIndex() ).on('mouseover',function()
		{
			if( Object.SetFlag == true )
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
		});

		$( "#Rating_1"+Object.GetIndex() ).on('mouseout',function()
		{ 
			if( Object.SetFlag == true )
			if(Object.JSON.Rating == "")
			{
				$( this ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			}
			else
			{
				var k = Object.JSON.Rating;
				for(var i=k+1;i<=2;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				}
			}

		});
	
		$( "#Rating_2"+Object.GetIndex() ).on('mouseover',function()
		{ 
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
			}
		});
		$( "#Rating_2"+Object.GetIndex() ).on('mouseout',function()
		{ 
			if( Object.SetFlag == true )
			if(Object.JSON.Rating == "")
			{
			$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( this ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			}
			else if(Object.JSON.Rating != "")
			{
				var k = Object.JSON.Rating;
				for(var i=k+1;i<=2;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				}
			}		
		});

		$( "#Rating_3"+Object.GetIndex() ).on('mouseover',function()
		{ 
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
			}
		});
		$( "#Rating_3"+Object.GetIndex() ).on('mouseout',function()
		{ 
			if( Object.SetFlag == true )
			if(Object.JSON.Rating == "")
			{
			$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( this ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			}
			else
			{
				var k = Object.JSON.Rating;
				for(var i=k+1;i<=3;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				}
			}
		});

		$( "#Rating_4"+Object.GetIndex() ).on('mouseover',function()
		{ 
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
			}
		});
		$( "#Rating_4"+Object.GetIndex() ).on('mouseout',function()
		{ 
			if( Object.SetFlag == true )
			if(Object.JSON.Rating == "")
			{
			$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( this ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			}
			else
			{
				var k = Object.JSON.Rating;
				for(var i=k+1;i<=4;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				}
			}
		});

		$( "#Rating_5"+Object.GetIndex() ).on('mouseover',function()
		{
			if( Object.SetFlag == true )
			{ 
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
			}
		});
		$( "#Rating_5"+Object.GetIndex() ).on('mouseout',function()
		{ 
			if( Object.SetFlag == true )
			if(Object.JSON.Rating == "")
			{
			$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			$( this ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
			}
			else
			{
				var k = Object.JSON.Rating;
				for(var i=k+1;i<=5;i++)
				{
					$( "#Rating_"+i+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				}
			}
		});

		$( "#Rating_1"+Object.GetIndex() ).on('click',function()
		{
			if( Object.SetFlag == true )
			{
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				$( "#Rating_5"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				Object.JSON.Rating = 1;

				Object.SetFlag = false;

				document.getElementById("userRating").value=1;

				if( $( "#ResetRating"+Object.GetIndex()+"" ).css( "visibility" ) == "hidden" )
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"visible"});
				else
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"hidden"});
			}
		});

		$( "#Rating_2"+Object.GetIndex() ).on('click',function()
		{
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
				$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				$( "#Rating_5"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				Object.JSON.Rating = 2;

				Object.SetFlag = false;

				document.getElementById("userRating").value=2;
				if( $( "#ResetRating"+Object.GetIndex()+"" ).css( "visibility" ) == "hidden" )
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"visible"});
				else
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"hidden"});
			}
		});

		$( "#Rating_3"+Object.GetIndex() ).on('click',function()
		{
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
				$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				$( "#Rating_5"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				Object.JSON.Rating = 3;

				Object.SetFlag = false;

				document.getElementById("userRating").value=3;
				if( $( "#ResetRating"+Object.GetIndex()+"" ).css( "visibility" ) == "hidden" )
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"visible"});
				else
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"hidden"});
			}
		});

		$( "#Rating_4"+Object.GetIndex() ).on('click',function()
		{
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
				$( "#Rating_5"+Object.GetIndex() ).css( {"background-color": "transparent","border":"0px solid rgb(145,141,2)", "color": col1+"","box-shadow":"1px 1px 5px "+col});
				Object.JSON.Rating = 4;

				Object.SetFlag = false;

				document.getElementById("userRating").value=4;

				if( $( "#ResetRating"+Object.GetIndex()+"" ).css( "visibility" ) == "hidden" )
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"visible"});
				else
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"hidden"});
			}
		});

		$( "#Rating_5"+Object.GetIndex() ).on('click',function()
		{
			if( Object.SetFlag == true )
			{
				$( "#Rating_1"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_2"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_3"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( "#Rating_4"+Object.GetIndex() ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"});
				$( this ).css( {"background-color": "rgb(128,0,0)","border":"0px solid rgb(145,141,2)", "color": "#FFFFFF","box-shadow":"0px 0px 10px #333333"}); 
				Object.JSON.Rating = 5;

				document.getElementById("userRating").value=5;

				Object.SetFlag = false;

				if( $( "#ResetRating"+Object.GetIndex()+"" ).css( "visibility" ) == "hidden" )
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"visible"});
				else
					$( "#ResetRating"+Object.GetIndex()+"" ).css( {"visibility":"hidden"});
			}
		});
	}
}