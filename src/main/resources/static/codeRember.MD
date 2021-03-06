   #1.多文件上传并保存到数据库：
  
    @RequestMapping(value = "/upload-double-file",method = RequestMethod.POST)
       @ResponseBody
       public Map<String,String> uploadDoubleFile(HttpServletRequest request,MusicView params){
   
           log.info("接收的上传请求参数：{}",JSON.toJSON(params));
           Map <String,String> result = new HashMap<>(16);
   
           //用list 接受上传的多个文件
           List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
           MultipartFile file = null;
           BufferedOutputStream stream = null;
           MusicView view  = new MusicView();
           String fullFilePath = null;
           String singer = null;
           for (int i = 0; i < files.size(); i++ ){
               file =files.get(i);
               if (!file.isEmpty()){
                   LocalDate now = LocalDate.now();
                   DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMdd");
                   String dateDir = now.format(dfm);
   
                   try{
                       String fileCode = String.valueOf(System.nanoTime());
                       //获取文件名
                       String oriFileName = file.getOriginalFilename();
                       //获取文件后缀名
                       String suffix = oriFileName.substring(oriFileName.lastIndexOf("."),oriFileName.length());
                       //文件上传路径
                       String dirPath = null;
                       if (".jpg".equals(suffix) || ".png".equals("suffix")){
                           dirPath =  Constants.path+musicImgPath;
                       }else if(".mp3".equals(suffix)){
                           dirPath =  Constants.path+musicVideoPath;
                       }
                       //fullFilePath = dirPath + fileCode+suffix;
                       fullFilePath = dirPath+oriFileName;
                       log.info("上传文件存储路径：{}",fullFilePath);
                       mkDir(new File(dirPath));
                       stream = new BufferedOutputStream(new FileOutputStream(fullFilePath));
                       stream.write(file.getBytes());
                       stream.flush();
                       stream.close();
                       //保存数据
                       view.setMusicName(oriFileName.substring(0,oriFileName.lastIndexOf(".")));
                       if (".jpg".equals(suffix) || ".png".equals(suffix)){
                           view.setMusicImg(oriFileName);
                       }
                       if (".mp3".equals(suffix)){
                           view.setMusicUrl(oriFileName);
                           log.info("suffix:{}",suffix);
                           view.setSinger(oriFileName.substring(0,oriFileName.indexOf("-")));
                       }
                   }catch (Exception e){
                       log.info("上传文件异常：{}",e.getMessage());
                       result.put("code","500");
                       result.put("message","上传文件异常");
                       return result;
                   }
               }
           }
           UserInfo userInfo = userInfoSessionUtils.findUserInfo(request);
           log.info("获取的用户信息：{}",userInfo);
           view.setCreator(userInfo.getNickName());
           view.setModifier(userInfo.getNickName());
           view.setUserId(userInfo.getUserId());
           view.setLyricContent(params.getLyricContent());
           view.setCommentTime(new Date());
           log.info("保存的参数是：{}",JSON.toJSON(view));
           musicService.saveMusic(view);
   
           result.put("code","200");
           result.put("message","成功");
           log.info("上文上传返回结果：{}",JSON.toJSON(result));
           return result;
       }